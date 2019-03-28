package whz.pti.eva.pizzaservice.security.boundary;

import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import whz.pti.eva.pizzaservice.customer.service.CustomerService;
import whz.pti.eva.pizzaservice.security.domain.UserCreateForm;
import whz.pti.eva.pizzaservice.security.service.dto.UserDTO;
import whz.pti.eva.pizzaservice.security.service.user.UserService;
import whz.pti.eva.pizzaservice.security.service.validator.UserCreateFormValidator;

@Controller
public class UserController
{

	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	private UserService userService;
	private CustomerService customerService;
	private UserCreateFormValidator userCreateFormValidator;

	@Autowired
	public UserController(UserService userService, UserCreateFormValidator userCreateFormValidator,CustomerService customerService)
	{
		this.userService = userService;
		this.userCreateFormValidator = userCreateFormValidator;
		this.customerService = customerService;
	}

	@InitBinder("UserCreateForm")
	public void initBinder(WebDataBinder binder)
	{
		binder.addValidators(userCreateFormValidator);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping("/users")
	public String getUsersPage(Model model)
	{
		log.info("Getting users page");
		model.addAttribute("users", userService.getAllUsers());
		return "users";
	}

	@PreAuthorize("#id == principal.id or hasAuthority('ADMIN')")
	@RequestMapping(value = "/users/{id}", method = { RequestMethod.POST, RequestMethod.GET })
	public String getUserPage(@PathVariable Long id, Model model)
	{
		log.debug("Getting user page for user= " + id);
		UserDTO userDTO = userService.getUserById(id);
		model.addAttribute("user", userDTO);
		model.addAttribute("fromUser", userDTO.getNickname());
		return "user";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/users/managed", method = { RequestMethod.POST, RequestMethod.GET })
	public String getUserManagedPage(Model model)
	{
		log.debug("Getting user create form");
		model.addAttribute("UserCreateForm", new UserCreateForm());
		model.addAttribute("users", userService.getAllUsers());
		return "user_create";
	}

	//PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/users/create", method = RequestMethod.POST)
	public String handleUserCreateForm(@Valid @ModelAttribute("UserCreateForm") UserCreateForm form,
			BindingResult bindingResult, Model model,HttpServletRequest request)
	{
		log.info("Processing user create form= " + form + " bindingResult= " + bindingResult);
		if (bindingResult.hasErrors())
		{
		    model.addAttribute("UserCreateForm", form);
			model.addAttribute("error", bindingResult.getGlobalError().getDefaultMessage());
			return "/fragments/register";
		}
		userService.create(form);
		customerService.createCustomer(form);
		
		try
		{
		    request.login(form.getEmail(), form.getPassword());
		} catch (ServletException e)
		{
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		return "redirect:/cart";
	}

	@RequestMapping(value = { "/register" }, method = {RequestMethod.POST,RequestMethod.GET})
	public String getRegisterPage(@RequestParam Optional<String> error, Model model) {
		log.debug("hallo bei Pizza");
		return "fragments/register";
	}
}

package whz.pti.eva.pizzaservice.security.boundary;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController
{

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = { "/login" }, method = {RequestMethod.GET,RequestMethod.POST})
    public String getLoginPage(@RequestParam Optional<String> error, Model model, HttpSession session)
    {
	log.debug("hallo bei Pizza");
	if(error.isPresent())System.out.println(error.get());
	return "fragments/login";

    }
    
    
    
    @RequestMapping("/403")
    public String accessDenied()
    {
	return "error/403";
    }

}

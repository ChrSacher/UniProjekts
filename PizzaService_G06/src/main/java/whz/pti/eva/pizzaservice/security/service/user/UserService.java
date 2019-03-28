package whz.pti.eva.pizzaservice.security.service.user;


import java.util.Collection;
import java.util.Optional;

import whz.pti.eva.pizzaservice.security.domain.CurrentUser;
import whz.pti.eva.pizzaservice.security.domain.User;
import whz.pti.eva.pizzaservice.security.domain.UserCreateForm;
import whz.pti.eva.pizzaservice.security.service.dto.UserDTO;


public interface UserService {

	UserDTO getUserById(long id);
	Optional<User> getUserByEmail(String email);
    boolean existsByNickname(String nickname);
    boolean existsByEmail(String email);
    Collection<UserDTO> getAllUsers();
    User create(UserCreateForm form);
    public  Optional<CurrentUser> getCurrentUser() ;
}

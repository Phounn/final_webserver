package web.group.two.user.service;

import web.group.two.user.dto.UserDTO;
import web.group.two.user.dto.UserRegisterDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findAllUser();

    UserDTO registerUser(UserRegisterDTO registerDTO);

    UserDTO updateUser(Long id, UserDTO userDTO);

    Boolean deleteUser(Long id);

    UserDTO getDetail(Long id);

}

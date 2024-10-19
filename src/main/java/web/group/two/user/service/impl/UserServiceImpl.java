package web.group.two.user.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import web.group.two.user.dto.UserDTO;
import web.group.two.user.dto.UserRegisterDTO;
import web.group.two.user.entity.User;
import web.group.two.user.repository.UserRepository;
import web.group.two.user.service.UserService;
import web.group.two.user.service.exception.UserNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private  final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ApplicationEventPublisher publisher;
    @Override
    public List<UserDTO> findAllUser() {
        return userRepository.findAll()
                .stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getDetail(Long id) {
        return userRepository.findById(id)
                .map(UserDTO::new)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public UserDTO registerUser(UserRegisterDTO registerDTO) {
        User user = User.createUserWithAccount(
                registerDTO.getName(),
                registerDTO.getAge(),
                registerDTO.getNickName(),
                registerDTO.getUsername(),
                passwordEncoder.encode(registerDTO.getPassword())
        );
        User savedUser = userRepository.save(user);
        return new UserDTO(savedUser);
    }


    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {

        User savedUser = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        savedUser.changeNickName(userDTO.getNickName());
        savedUser.changeName(userDTO.getName());
        savedUser.changeAge(userDTO.getAge());
        User updateUser = userRepository.save(savedUser);
        return new UserDTO(updateUser);
    }
    @Override
    public Boolean deleteUser(Long id) {
        final User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
        return Boolean.TRUE;
    }
}

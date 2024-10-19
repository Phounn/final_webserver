package web.group.two.user.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.group.two.user.entity.LoginUser;
import web.group.two.user.entity.User;
import web.group.two.user.repository.UserRepository;
import web.group.two.user.service.exception.UserNotFoundException;


@Service
@RequiredArgsConstructor
public class UserLogService implements UserDetailsService {
    final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userRepository.findByAccount_username(username)
                .orElseThrow(UserNotFoundException::new);

        return new LoginUser(user);
    }
}

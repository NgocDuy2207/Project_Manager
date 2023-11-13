package manager.container.service;

import manager.container.entity.MyUserDetails;
import manager.container.entity.User;
import manager.container.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User users = userRepository.getUserByUsername(username);
        if (users == null){
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(users);
    }
}

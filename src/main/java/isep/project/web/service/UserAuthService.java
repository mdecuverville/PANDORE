package isep.project.web.service;

import isep.project.web.dao.UserDAO;
import isep.project.web.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;

public class UserAuthService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        UserEntity activeUserInfo = userDAO.getUser(email);
        GrantedAuthority authority = new SimpleGrantedAuthority(activeUserInfo.getRole());
        return new User(activeUserInfo.getEmail(), activeUserInfo.getPasswordHash(), Arrays.asList(authority));
    }
}

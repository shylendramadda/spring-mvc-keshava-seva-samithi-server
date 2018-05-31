package com.rss.keshava.config.security;

import com.rss.keshava.domain.User;
import com.rss.keshava.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SecurityUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmailOrMobile(username, username);
        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }
        SecurityUser securityUser = new SecurityUser(user, getAuthorities(user));
        return securityUser;
    }

    private List<GrantedAuthority> getAuthorities(User user) {
        return AuthorityUtils.createAuthorityList(user.getRoles());
    }
}

package com.github.osivaM.pp_3_1_4_maven.services.impl;

import com.github.osivaM.pp_3_1_4_maven.models.User;
import com.github.osivaM.pp_3_1_4_maven.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findUserByName(username)
                .map(User::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }

}

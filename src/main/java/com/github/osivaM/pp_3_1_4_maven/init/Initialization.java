package com.github.osivaM.pp_3_1_4_maven.init;

import com.github.osivaM.pp_3_1_4_maven.models.Role;
import com.github.osivaM.pp_3_1_4_maven.models.User;
import com.github.osivaM.pp_3_1_4_maven.repositories.RoleRepository;
import com.github.osivaM.pp_3_1_4_maven.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class Initialization {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public Initialization(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    private void init() {
        Role role_admin = new Role("ROLE_ADMIN");
        Role role_user = new Role("ROLE_USER");

        List<Role> roles = new ArrayList<>(Arrays.asList(role_admin, role_user));

        User user = new User("admin",
                "admin",
                (byte) 1,
                passwordEncoder.encode("password"),
                roles);

        role_admin.setUsers(Collections.singletonList(user));
        role_user.setUsers(Collections.singletonList(user));

        roleRepository.save(role_admin);
        roleRepository.save(role_user);
        userRepository.save(user);
    }

}

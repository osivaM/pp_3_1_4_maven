package com.github.osivaM.pp_3_1_4_maven;

import com.github.osivaM.pp_3_1_4_maven.models.Role;
import com.github.osivaM.pp_3_1_4_maven.models.User;
import com.github.osivaM.pp_3_1_4_maven.repositories.RoleRepository;
import com.github.osivaM.pp_3_1_4_maven.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class Pp314MavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(Pp314MavenApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserRepository userRepository,
											   RoleRepository roleRepository,
											   PasswordEncoder passwordEncoder
	) {
		return args -> {
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
		};
	}

}

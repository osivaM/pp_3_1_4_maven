package com.github.osivaM.pp_3_1_4_maven.repositories;

import com.github.osivaM.pp_3_1_4_maven.models.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserRepository extends ListCrudRepository<User, Long> {

    Optional<User> findUserByName(String name);

}

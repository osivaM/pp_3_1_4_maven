package com.github.osivaM.pp_3_1_4_maven.repositories;

import com.github.osivaM.pp_3_1_4_maven.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserRepository extends ListCrudRepository<User, Long> {

    @Query("Select u from User u left join fetch u.roles where u.name=:name")
    Optional<User> findUserByName(String name);

}

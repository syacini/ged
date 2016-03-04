package com.ged.dao.master;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ged.domain.master.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findOneByUsername(String usernamename);

}

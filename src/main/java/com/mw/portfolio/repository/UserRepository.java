package com.mw.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mw.portfolio.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	

}

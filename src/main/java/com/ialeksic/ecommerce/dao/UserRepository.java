package com.ialeksic.ecommerce.dao;

import com.ialeksic.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User getByEmail(String email);

	User getByUsername(String username);

	User getByUUID(String UUID);
}

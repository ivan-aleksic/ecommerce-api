package com.ialeksic.ecommerce.service;

import com.google.common.hash.Hashing;
import com.ialeksic.ecommerce.dao.UserRepository;
import com.ialeksic.ecommerce.dto.UserDto;
import com.ialeksic.ecommerce.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService {
	private final UserRepository userRepository;

	public Boolean attemptLogin(String email, String password) {
		User user = userRepository.getByEmail(email);
		if (user == null) {
			return false;
		}
		String enryptedPassword = encryptPassword(password + user.getPasswordSalt());
		return enryptedPassword.equals(user.getPassword());
	}

	public User createUser(UserDto userDto) {
		String salt = UUID.randomUUID().toString().split("-")[0];
		String saltedPassword = userDto.password + salt;
		String encryptedPassword = encryptPassword(saltedPassword);

		User user = User.builder()
				.password(encryptedPassword)
				.passwordSalt(salt)
				.email(userDto.email)
				.username(userDto.username)
				.build();
		User dbUser = userRepository.save(user);
		return dbUser;
	}

	private String encryptPassword(String password) {
		return Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
	}
}

package com.ialeksic.ecommerce.controller;

import com.ialeksic.ecommerce.dto.UserDto;
import com.ialeksic.ecommerce.entity.User;
import com.ialeksic.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
	private final UserService userService;

	@GetMapping("/login")
	public ResponseEntity<?> doLogin(@RequestParam String email, @RequestParam String password) {
		Boolean success = userService.attemptLogin(email, password);
		if (success) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@PostMapping("/register")
	public ResponseEntity<User> doRegister(@RequestBody UserDto userDto) {
		return ResponseEntity.ok(userService.createUser(userDto));
	}
}

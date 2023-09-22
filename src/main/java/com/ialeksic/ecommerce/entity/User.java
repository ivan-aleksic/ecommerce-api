package com.ialeksic.ecommerce.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Auser")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "email", unique = true)
	private String email;
	private String username;
	private String password;
	private String passwordSalt;
}

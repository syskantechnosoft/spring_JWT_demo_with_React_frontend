package com.syskan.authservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

	@Id
	private String id;
	private String fullName;
	private String email;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	private String role = "ROLE_CUSTOMER";
	private String mobile;

}

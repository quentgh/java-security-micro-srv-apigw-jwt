package com.myorg.dtos;

import java.util.List;

import com.myorg.entities.AppRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {
	private String lastname;
	private String firstname;
	private String email;
	private String password;
	private List<AppRole> roles;

}

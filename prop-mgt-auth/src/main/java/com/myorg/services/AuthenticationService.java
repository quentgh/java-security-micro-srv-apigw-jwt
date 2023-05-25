package com.myorg.services;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myorg.config.JwtService;
import com.myorg.dtos.AuthenticationRequestDto;
import com.myorg.dtos.AuthenticationResponseDto;
import com.myorg.dtos.RegisterRequestDto;
import com.myorg.entities.AppUser;
import com.myorg.repositories.AppUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationService {
	private final AppUserRepository userRepository;
	private final AccountService accountService;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;

	public ResponseEntity<AuthenticationResponseDto> register(RegisterRequestDto request) {
		if (userRepository.findByEmail(request.getEmail()).isPresent()) {
			return ResponseEntity.badRequest()
					.body(AuthenticationResponseDto.builder().message("User already exist").build());
		}

		var user = AppUser.builder().email(request.getEmail()).lastname(request.getLastname())
				.firstname(request.getFirstname()).password(request.getPassword()).roles(new ArrayList<>()).build();

		accountService.addNewUser(user);
		accountService.addRoleToUser(user, request.getRoles());

		var jwtToken = jwtService.generateToken(user);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Authorization", "Bearer " + jwtToken);

		return ResponseEntity.ok().headers(responseHeaders)
				.body(AuthenticationResponseDto.builder().message("User registered with success").build());
	}

	public ResponseEntity<String> authenticate(AuthenticationRequestDto request) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		var user = userRepository.findByEmail(request.getEmail())
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		var jwtToken = jwtService.generateToken(user);
		
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.add("Authorization", "Bearer " + jwtToken);
//		return ResponseEntity.ok().headers(responseHeaders).body("ok");
		
		return ResponseEntity.ok().body(jwtToken);
	}

}

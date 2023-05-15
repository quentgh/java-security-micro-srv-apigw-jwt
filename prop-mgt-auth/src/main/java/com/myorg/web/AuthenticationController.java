package com.myorg.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myorg.dtos.AuthenticationRequestDto;
import com.myorg.dtos.RegisterRequestDto;
import com.myorg.services.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
	@Autowired
	private AuthenticationService authentService;

	@PostMapping(path = "/register")
	public ResponseEntity<?> register(@RequestBody RegisterRequestDto request) {
		return authentService.register(request);
	}

	@PostMapping(path = "/login")
	public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequestDto request) {
		return authentService.authenticate(request);
	}

}

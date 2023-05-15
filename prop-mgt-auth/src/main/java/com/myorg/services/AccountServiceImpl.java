package com.myorg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myorg.entities.AppRole;
import com.myorg.entities.AppUser;
import com.myorg.repositories.AppRoleRepository;
import com.myorg.repositories.AppUserRepository;
import com.myorg.tools.CustomPasswordEncoder;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AppRoleRepository appRoleRepository;
	@Autowired
	private AppUserRepository appUserRepository;
	@Autowired
	private CustomPasswordEncoder passwordEncoder;

	@Override
	public AppUser addNewUser(AppUser user) {
		String pwd = user.getPassword();
		String pwdEncrypted = passwordEncoder.encode(pwd);

		user.setPassword(pwdEncrypted);
		return appUserRepository.save(user);
	}

	@Override
	public AppRole addNewRole(AppRole role) {
		return appRoleRepository.save(role);
	}

	@Override
	public void addRoleToUser(AppUser user, List<AppRole> roles) {
		AppUser existingUser = appUserRepository.findByEmail(user.getEmail()).orElse(null);

		roles.stream().map(AppRole::getRoleName).map(appRoleRepository::findByRoleName)
				.forEach(existingUser.getRoles()::add);
		appUserRepository.save(existingUser);
	}

}

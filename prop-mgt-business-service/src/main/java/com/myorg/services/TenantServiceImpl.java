package com.myorg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myorg.entities.Tenant;
import com.myorg.repositories.TenantRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TenantServiceImpl implements TenantService {

	@Autowired
	TenantRepository tenantRepository;

	@Override
	public Tenant addTenant(Tenant tenant) {
		Optional<Tenant> isExistLessee = tenantRepository.findByEmail(tenant.getEmail());
		if (isExistLessee.isPresent()) {
			throw new IllegalArgumentException("Email " + isExistLessee + " already exists !");
		}
		return tenantRepository.save(tenant);

	}

	@Override
	public Tenant login(String login, String password) {
		Optional<Tenant> existingUser = tenantRepository.findByEmail(login);
		if (!existingUser.isPresent()) {
			throw new IllegalArgumentException("User doesn't exist, sorry...");
		}

		Tenant tenant = existingUser.get();

		if (!tenant.getPassword().equals(password)) {
			throw new IllegalArgumentException("Authentification failed...");
		}
		return tenant;
	}

	@Override
	public List<Tenant> getTenants() {
		return tenantRepository.findAll();
	}

	@Override
	public Tenant deleteTenant(Tenant tenant) {
		Optional<Tenant> existingUser = tenantRepository.findByEmail(tenant.getEmail());

		if (!existingUser.isPresent()) {
			throw new IllegalArgumentException("User doesn't exist, sorry...");
		}

		tenant = existingUser.get();
		tenant.setEmail(tenant.getEmail() + "DELETED");

		return tenantRepository.save(tenant);
	}

}

package com.myorg.services;

import java.util.List;

import com.myorg.entities.Tenant;

public interface TenantService {
	Tenant addTenant(Tenant tenant);

	Tenant login(String login, String password);

	List<Tenant> getTenants();

	Tenant deleteTenant(Tenant tenant);
}

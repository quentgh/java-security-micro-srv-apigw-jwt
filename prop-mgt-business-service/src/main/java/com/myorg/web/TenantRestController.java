package com.myorg.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myorg.entities.Tenant;
import com.myorg.services.TenantService;

@RestController
@RequestMapping("api/v1/business")
public class TenantRestController {
	@Autowired
	private TenantService tenantService;

	@PostMapping(path = "/addTenant")
	public void addLessee(@RequestBody Tenant tenant) {
		tenantService.addTenant(tenant);
	}

	@GetMapping(path = "/tenants")
	public List<Tenant> getLessee() {
		return tenantService.getTenants();
	}

	@PutMapping(path = "/deleteTenant")
	public void deleteLessee(@RequestBody Tenant tenant) {
		tenantService.deleteTenant(tenant);
	}

}

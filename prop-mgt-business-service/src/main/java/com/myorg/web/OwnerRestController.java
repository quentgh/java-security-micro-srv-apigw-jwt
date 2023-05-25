package com.myorg.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myorg.entities.Owner;
import com.myorg.services.OwnerService;

@RestController
@RequestMapping("api/v1/business")
public class OwnerRestController {
	@Autowired
	private OwnerService ownerService;

	@PostMapping(path = "/addOwner")
	public void addOwner(@RequestBody Owner owner) {
		ownerService.addOwner(owner);
	}

	@GetMapping(path = "/owners")
	public List<Owner> getOwners() {
		return ownerService.getOwners();
	}

	@PutMapping(path = "/deleteOwner")
	public void deleteOwner(@RequestBody Owner owner) {
		ownerService.deleteOwner(owner);
	}
}

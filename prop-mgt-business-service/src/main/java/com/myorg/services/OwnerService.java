package com.myorg.services;

import java.util.List;

import com.myorg.entities.Owner;

public interface OwnerService {
	Owner addOwner(Owner owner);

	Owner login(String login, String password);

	List<Owner> getOwners();

	Owner deleteOwner(Owner owner);

}

package com.myorg.services;

import java.util.List;

import com.myorg.entities.AppRole;
import com.myorg.entities.AppUser;

public interface AccountService {
	AppUser addNewUser(AppUser user);

	AppRole addNewRole(AppRole role);

	void addRoleToUser(AppUser user, List<AppRole> roles);

}

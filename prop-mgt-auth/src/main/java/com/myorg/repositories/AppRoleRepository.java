package com.myorg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myorg.entities.AppRole;
import com.myorg.enums.RoleName;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
	AppRole findByRoleName(RoleName roleName);
}

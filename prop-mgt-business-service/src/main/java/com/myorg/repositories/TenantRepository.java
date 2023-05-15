package com.myorg.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.myorg.entities.Tenant;

@RepositoryRestResource
public interface TenantRepository extends JpaRepository<Tenant, Long> {
	@RestResource(path = "/byEmail")
	Optional<Tenant> findByEmail(@Param(value = "email") String email);
}

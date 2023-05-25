package com.myorg.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.myorg.entities.Owner;

@RepositoryRestResource
public interface OwnerRepository extends JpaRepository<Owner, Long> {
	@RestResource(path = "/byEmail")
	Optional<Owner> findByEmail(@Param(value = "email") String email);
}

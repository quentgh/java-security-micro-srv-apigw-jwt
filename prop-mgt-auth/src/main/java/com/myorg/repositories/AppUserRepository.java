package com.myorg.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myorg.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
	Optional<AppUser> findByEmail(String email);
}

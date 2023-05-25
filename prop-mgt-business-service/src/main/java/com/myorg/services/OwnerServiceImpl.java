package com.myorg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myorg.entities.Owner;
import com.myorg.repositories.OwnerRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService {

	@Autowired
	OwnerRepository ownerRepository;

	@Override
	public Owner addOwner(Owner owner) {
		Optional<Owner> isExistTenant = ownerRepository.findByEmail(owner.getEmail());
		if (isExistTenant.isPresent()) {
			throw new IllegalArgumentException("Email " + isExistTenant + " already exists !");
		}
		return ownerRepository.save(owner);

	}

	@Override
	public Owner login(String login, String password) {
		Optional<Owner> existingOwner = ownerRepository.findByEmail(login);
		if (!existingOwner.isPresent()) {
			throw new IllegalArgumentException("User doesn't exist, sorry...");
		}

		Owner owner = existingOwner.get();

		if (!owner.getPassword().equals(password)) {
			throw new IllegalArgumentException("Authentification failed...");
		}
		return owner;
	}

	@Override
	public List<Owner> getOwners() {
		return ownerRepository.findAll();
	}

	@Override
	public Owner deleteOwner(Owner owner) {
		Optional<Owner> existingOwner = ownerRepository.findByEmail(owner.getEmail());

		if (!existingOwner.isPresent()) {
			throw new IllegalArgumentException("User doesn't exist, sorry...");
		}

		owner = existingOwner.get();
		owner.setEmail(owner.getEmail() + "DELETED");

		return ownerRepository.save(owner);
	}

}

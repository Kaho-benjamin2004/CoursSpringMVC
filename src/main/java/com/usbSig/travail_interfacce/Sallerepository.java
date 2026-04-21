package com.usbSig.travail_interfacce;

import com.usbSig.travail_cinema.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface Sallerepository extends JpaRepository<Salle, Long> {
	
}

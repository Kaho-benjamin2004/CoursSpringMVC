package com.usbSig.travail_interfacce;

import com.usbSig.travail_cinema.ProjectionFilm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectionRepository extends JpaRepository<ProjectionFilm,Long> {
}

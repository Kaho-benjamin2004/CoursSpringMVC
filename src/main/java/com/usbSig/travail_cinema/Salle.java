package com.usbSig.travail_cinema;

import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Salle  implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int nombrePlaces;
	
	@ManyToOne
	private Cinema cinema;
	
	@OneToMany(mappedBy = "salle")
	private Collection<ProjectionFilm>projectionFilms;
	
	@OneToMany(mappedBy = "salle")
	private Collection<Place>places;

	
}

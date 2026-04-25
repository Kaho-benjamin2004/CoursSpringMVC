package com.usbSig.travail_cinema;

import java.io.Serializable;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;
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
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Cinema cinema;
	
	@OneToMany(mappedBy = "salle")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Collection<ProjectionFilm>projectionFilms;
	
	@OneToMany(mappedBy = "salle")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Collection<Place>places;

	
}

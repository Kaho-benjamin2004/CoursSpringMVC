package com.usbSig.travail_cinema;

import java.io.Serializable;
import java.sql.Date;
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
public class Film  implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titre;
	private double duree;
	private String realisateur;
	private String description;
	private String photo;
	private Date dateSortie;
	
	@OneToMany(mappedBy = "film")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Collection<ProjectionFilm>projectionFilms;
	
	@ManyToOne
	private Categorie categorie;
	

	
}

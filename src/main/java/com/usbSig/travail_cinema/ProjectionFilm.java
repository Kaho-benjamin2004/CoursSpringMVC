package com.usbSig.travail_cinema;

import java.io.Serializable;

import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectionFilm  implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dateProjection;
	private double prix;
	
	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Salle salle;
	
	@ManyToOne
	private Film film;
	
	@OneToMany(mappedBy = "projectionFilm")
	private Collection<Ticket>tickets;
	@ManyToOne
	@JoinColumn(name = "seance_id")
	private Seance seance;


}

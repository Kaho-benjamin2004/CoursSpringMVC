package com.usbSig.travail_cinema;

import java.io.Serializable;

import java.util.Collection;
import java.util.Date;

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
	private Salle salle;
	
	@ManyToOne
	private Film film;
	
	@OneToMany(mappedBy = "projectionFilm")
	private Collection<Ticket>tickets;
	@ManyToOne
	@JoinColumn(name = "seance_id")
	private Seance seance;


}

package com.usbSig.travail_cinema;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nomClient;
    private double prix;
    
    // Utilisation de Integer pour permettre une valeur NULL en base de données
    @Column(unique = true, nullable = true)
    private Integer codePayement; 
    
    private boolean reservee;
    
    @ManyToOne
    private Place place;
    
    @ManyToOne
    private ProjectionFilm projectionFilm;
}
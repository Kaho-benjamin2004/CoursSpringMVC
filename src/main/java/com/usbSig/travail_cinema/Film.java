package com.usbSig.travail_cinema;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date; // Utilisation de java.util.Date pour plus de flexibilité

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Film implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titre;
    private double duree;
    private String realisateur;
    private String description;
    private String photo;
    
    @Temporal(TemporalType.DATE)
    private Date dateSortie;
    
    @OneToMany(mappedBy = "film")
    private Collection<ProjectionFilm> projectionFilms;
    
    @ManyToOne
    private Categorie categorie;

    // --- Getters et Setters explicites ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public double getDuree() {
        return duree;
    }

    public void setDuree(double duree) {
        this.duree = duree;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public Collection<ProjectionFilm> getProjectionFilms() {
        return projectionFilms;
    }

    public void setProjectionFilms(Collection<ProjectionFilm> projectionFilms) {
        this.projectionFilms = projectionFilms;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
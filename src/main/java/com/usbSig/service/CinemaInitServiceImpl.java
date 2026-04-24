package com.usbSig.service;

import com.usbSig.travail_cinema.*;
import com.usbSig.travail_interfacce.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
@Transactional
public class CinemaInitServiceImpl implements ICinemaInitService{
    @Autowired
    private VilleRepository villeRepository;
    @Autowired
    private Cinema_repository cinemaRepository;
    @Autowired
    private Sallerepository sallerepository;

    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private SeanceRepository seanceRepository;
    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private ProjectionRepository projectionRepository;

    @Autowired
    private CategrieRepository categrieRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Override
    public void initVilles() {
        Stream.of("Casablanca","Marrakech","Rabat","Tanger").forEach(nameVille->{
            Ville ville=new Ville();
            ville.setName(nameVille);
            villeRepository.save(ville);
        });
    }

    @Override
    public void initCinamas() {
        villeRepository.findAll().forEach(v->{
            Stream.of("MagaRama","IMAX","FOUNOUN","DAOULIZ").forEach(
                    nameCinema->{
                        Cinema cinema=new Cinema();
                        cinema.setName(nameCinema);
                        cinema.setNombreSalles(3+ (int) (Math.random() * 7));
                        cinema.setVille(v);
                        cinemaRepository.save(cinema);
                    }
            );
        });

    }

    @Override
    public void initSalle() {
        cinemaRepository.findAll().forEach(cinema -> {
            for (int i=0;i<cinema.getNombreSalles();i++){
                Salle  salle=new Salle();
                salle.setName("salle "+(i+1));
                salle.setCinema(cinema);
                salle.setNombrePlaces(15+(int) (Math.random()*20));
                sallerepository.save(salle);
            }
        });

    }

    @Override
    public void initSeances() {
        DateFormat dateFormat=new SimpleDateFormat("HH:mm");
        Stream.of("12:00","15:00","17:00","19:00","21:00").forEach(
                s->{
                    Seance seance=new Seance();
                    try {
                        seance.setHeureDebut((Date) dateFormat.parse(s));
                        seanceRepository.save(seance);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                }
        );


    }

    @Override
    public void initPlaces() {
        sallerepository.findAll().forEach(salle -> {
            for (int i=0;i<salle.getNombrePlaces();i++){
                Place place=new Place();
                place.setNumero(i+1);
                place.setSalle(salle);
                placeRepository.save(place);
            }
        });

    }

    @Override
    public void initCategories() {
        Stream.of("Histoire","Action","Fiction","Drama").forEach(cat->{
            Categorie categorie=new Categorie();
            categorie.setName(cat);
            categrieRepository.save(categorie);
        });
    }

    @Override
    public void films() {
        double[] durees=new double[]{1,1.5,2,2,2.5,3};
        List<Categorie> categories=categrieRepository.findAll();
        Stream.of("Game of Strong","Seigneur des anneaux","Spider man","Cat Woman")
                .forEach(titrefilm->{
                    Film film=new Film();
                    film.setTitre(titrefilm);
                    film.setDuree(durees[new Random().nextInt(durees.length)]);
                    film.setPhoto(titrefilm.replaceAll("",""));
                    film.setCategorie(categories.get(new Random().nextInt(categories.size())));
                    filmRepository.save(film);
                });
    }

    @Override
    public void initProjections() {
        double[] prix=new double[] {30,50,60,70,90,100};
        villeRepository.findAll().forEach(ville -> {
            ville.getCinemas().forEach(cinema -> {
                cinema.getSalles().forEach(salle -> {
                    filmRepository.findAll().forEach(film -> {
                        seanceRepository.findAll().forEach(seance -> {
                            ProjectionFilm projection=new ProjectionFilm();
                            projection.setDateProjection(new java.util.Date());
                            projection.setFilm(film);
                            projection.setPrix(prix[new Random().nextInt(prix.length)]);
                            projection.setSalle(salle);
                            projection.setSeance(seance);
                            projectionRepository.save(projection);
                        });
                    });
                });
            });
        });

    }

    @Override
    public void initTicket() {
        projectionRepository.findAll().forEach(p->{
           p.getSalle().getPlaces().forEach(place -> {
               Ticket ticket=new Ticket();
               ticket.setPlace(place);
               ticket.setPrix(p.getPrix());
               ticket.setProjectionFilm(p);
               ticket.setReservee(false);
               ticketRepository.save(ticket);
           });
        });

    }
}

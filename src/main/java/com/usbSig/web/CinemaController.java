package com.usbSig.web;

import com.usbSig.SERVICE.cinemaService;
import com.usbSig.travail_cinema.Film;
import com.usbSig.travail_cinema.Ticket;
import com.usbSig.travail_cinema.TicketForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CinemaController {
    private  final cinemaService serviceCinema;

    @GetMapping("/listFilms")
    public List<Film> fimls(){
        return serviceCinema.fimls();
    }
    @GetMapping(path = "/imageFilm/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public  byte[] image(@PathVariable(name = "id") Long id) throws Exception {
        return serviceCinema.image(id);
    }
    @PostMapping("/payerTickets")
    public List<Ticket> payerTocket(@RequestBody TicketForm ticketForm){
        return serviceCinema.payerTocket(ticketForm);
    }

}

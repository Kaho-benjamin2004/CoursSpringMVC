package com.usbSig.SERVICE;

import com.usbSig.travail_cinema.Film;
import com.usbSig.travail_cinema.Ticket;
import com.usbSig.travail_cinema.TicketForm;
import com.usbSig.travail_interfacce.FilmRepository;
import com.usbSig.travail_interfacce.TicketRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class cinemaService {
    private final  FilmRepository filmRepository;
    private final TicketRepository ticketRepository;

    public List<Film> fimls(){
        return filmRepository.findAll();
    }
 public  byte[] image(Long id)
         throws Exception{
      Film f=  filmRepository.findById(id).get();
      String PhotoName=f.getPhoto();
        File file=new File(System.getProperty("user.home")+"/cinema/images/"+PhotoName+".jpg");
        Path path= Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }

    public List<Ticket> payerTocket(TicketForm ticketForm){
        List<Ticket> ticketList=new ArrayList<>();
        ticketForm.getTickets().forEach(idTicket->{
         //   System.out.println(idTicket);
          Ticket ticket=  ticketRepository.findById(idTicket).get();
          ticket.setNomClient(ticketForm.getNomClient());
          ticket.setReservee(true);
          ticketRepository.save(ticket);
          ticketList.add(ticket);
        });
        return ticketList;
    }


}


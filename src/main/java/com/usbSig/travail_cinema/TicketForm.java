package com.usbSig.travail_cinema;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TicketForm {
    private String nomClient;
    private List<Long> tickets=new ArrayList<>();
}
package com.usbSig.travail_cinema;

import java.io.Serializable;
import java.util.Date;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Temporal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seance   implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date heureDebut;

}

package com.example.foyer.controller;

import com.example.foyer.entity.Reservation;
import com.example.foyer.service.IReservationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reservation")
@RequiredArgsConstructor
public class ReservationController {
    private final IReservationService reservationService;
    @GetMapping
    public List<Reservation> retrieveAllFoyers() {
        return reservationService.retrieveAllReservation();
    }


    @PutMapping
    public Reservation updateReservation(@RequestBody Reservation r) {
        return reservationService.updateReservation(r);
    }

    @GetMapping("{idReservation}")
    public Reservation retrieveReservation(@PathVariable long idReservation) {
        return reservationService.retrieveReservation(idReservation);
    }
    @PostMapping("{idChambre}/{cinEtudiant}")
    public Reservation ajouterReservation (@PathVariable long idChambre,@PathVariable long cinEtudiant){
        return reservationService.ajouterReservation(idChambre,cinEtudiant);
    } ;

}

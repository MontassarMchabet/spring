package com.example.foyer.service;

import com.example.foyer.entity.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservation();

    Reservation updateReservation (Reservation res);

    Reservation retrieveReservation (long idReservation);

    Reservation ajouterReservation(long idChambre, long cinEtudiant);
}

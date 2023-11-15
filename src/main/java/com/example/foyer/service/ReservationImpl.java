package com.example.foyer.service;

import com.example.foyer.entity.Reservation;
import com.example.foyer.repository.ReservationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ReservationImpl implements IReservationService{
    private final ReservationRepo reservationRepo;
    @Override
    public List<Reservation> retrieveAllReservation() {
        return (List<Reservation>) reservationRepo.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return reservationRepo.save(res);
    }



    @Override
    public Reservation retrieveReservation(long idReservation) {
        return reservationRepo.findById(idReservation).orElse(null);
    }
}

package com.example.foyer.repository;

import com.example.foyer.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepo extends CrudRepository<Reservation,Long> {
}

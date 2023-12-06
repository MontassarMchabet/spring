package com.example.foyer.repository;

import com.example.foyer.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepo extends CrudRepository<Reservation,Long> {
}

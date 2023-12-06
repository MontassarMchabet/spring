package com.example.foyer.service;


import com.example.foyer.entity.Chambre;
import com.example.foyer.entity.Enum.TypeChambre;
import com.example.foyer.entity.Etudiant;
import com.example.foyer.entity.Reservation;
import com.example.foyer.repository.ChambreRepo;
import com.example.foyer.repository.EtudiantRepo;
import com.example.foyer.repository.ReservationRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
public class ReservationImpl implements IReservationService{
    private final ReservationRepo reservationRepo;
    private final EtudiantRepo etudiantRepo;
    private  final ChambreRepo chambreRepo;

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

//    @Override
//    public Reservation ajouterReservation(long idChambre, long cinEtudiant) {
//        return null;
//    }

    @Override
    public Reservation ajouterReservation(long idChambre, long cinEtudiant) {

        Etudiant etudiant=etudiantRepo.findByCin(cinEtudiant);

        Chambre chambre=chambreRepo.findById(idChambre).orElse(null);
        System.out.println("aaa");
        String IdReservation = (chambre.getNumeroChambre()+'-'+chambre.getBlocs().getNomBloc()+'-'+LocalDate.now().getYear());
        System.out.println(IdReservation);
        Reservation reservations = etudiant.getReservations().stream()
                .filter(reservation -> reservation.getIdReservation().equals(IdReservation))
                .findFirst()
                .get();
        System.out.println("aaaaaaaaaaaaaaa");
        //Reservation reservations=new Reservation();
         if (reservations.getIdReservation()==null) {
            reservations.setIdReservation(chambre.getNumeroChambre()+'-'+chambre.getBlocs().getNomBloc()+'-'+LocalDate.now().getYear());
             reservations.setAnneeUniversitaire(LocalDate.now());
            // Initialisez list d'étudiants s'il est null
            if (reservations.getEtudiants() == null) {
                reservations.setEtudiants(new HashSet<>());
            }
             reservations.getEtudiants().add(etudiant);
             reservations.setEstValide(true);

             return reservations;
        }

        long nbrReservation = chambre.getReservations().size();
        if(!reservations.isEstValide()){
            System.out.println("la reservation est impossible ");

           }
        else {
            TypeChambre typeChambre=chambre.getTypeChambre();

            if (typeChambre==TypeChambre.SIMPLE && nbrReservation==0){
                chambre.getReservations().add(reservations);
                reservations.setEstValide(false);
                etudiant.getReservations().add(reservations);
            }
            else if (typeChambre==TypeChambre.DOUBLE && nbrReservation==0) {
                chambre.getReservations().add(reservations);
            }
            else if (typeChambre==TypeChambre.DOUBLE && nbrReservation==1) {
                chambre.getReservations().add(reservations);
                reservations.setEstValide(false);
                etudiant.getReservations().add(reservations);
            }
            else if (typeChambre==TypeChambre.TRIPLE && (nbrReservation==1||nbrReservation==0 )) {
                chambre.getReservations().add(reservations);
            }
            else {
                chambre.getReservations().add(reservations);
                reservations.setEstValide(false);
                etudiant.getReservations().add(reservations);
            }
        }
        chambreRepo.save(chambre);

        return reservationRepo.save(reservations) ;
    }
}

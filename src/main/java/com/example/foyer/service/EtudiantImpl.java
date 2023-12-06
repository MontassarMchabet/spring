package com.example.foyer.service;

import com.example.foyer.entity.Etudiant;
import com.example.foyer.repository.EtudiantRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
public class EtudiantImpl implements IEtudiantService{
    private final EtudiantRepo etudiantRepo;
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return (List<Etudiant>) etudiantRepo.findAll();
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return (List<Etudiant>) etudiantRepo.saveAll(etudiants);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepo.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
        return etudiantRepo.findById(idEtudiant).orElseThrow(()->new IllegalArgumentException("Etudiant with ID " + idEtudiant + " not found"));
    }

    @Override
    public void removeEtudiant(long idEtudiant) {
        etudiantRepo.deleteById(idEtudiant);

    }
}

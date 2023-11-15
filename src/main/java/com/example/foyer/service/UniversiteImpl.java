package com.example.foyer.service;

import com.example.foyer.entity.Universite;
import com.example.foyer.repository.UniversiteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UniversiteImpl implements IUniversiteService{
    private final UniversiteRepo universiteRepo;
    @Override
    public List<Universite> retrieveAllUniversities() {
        return (List<Universite>) universiteRepo.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepo.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepo.save(u);
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        return universiteRepo.findById(idUniversite).orElse(null);
    }
}

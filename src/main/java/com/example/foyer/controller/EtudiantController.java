package com.example.foyer.controller;

import com.example.foyer.entity.Etudiant;
import com.example.foyer.service.IEtudiantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("etudiant")
@RequiredArgsConstructor
public class EtudiantController {
    private final IEtudiantService iEtudiantService;
    @GetMapping
    public List<Etudiant> retrieveAllEtudiants() {
        return iEtudiantService.retrieveAllEtudiants();
    }

    @PostMapping
    public List<Etudiant> addEtudiants(@RequestBody List<Etudiant> etudiants) {
        return iEtudiantService.addEtudiants(etudiants);
    }

    @PutMapping
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        return iEtudiantService.updateEtudiant(e);
    }

    @GetMapping("{idEtudiant}")
    public Etudiant retrieveEtudiant( @PathVariable long idEtudiant) {
        return iEtudiantService.retrieveEtudiant(idEtudiant);
    }

    @DeleteMapping("{idEtudiant}")
    public void removeEtudiant(@PathVariable long idEtudiant) {
        iEtudiantService.removeEtudiant(idEtudiant);

    }
}

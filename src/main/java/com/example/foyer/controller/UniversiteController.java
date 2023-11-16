package com.example.foyer.controller;

import com.example.foyer.entity.Universite;
import com.example.foyer.service.IUniversiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("universite")
@RequiredArgsConstructor

public class UniversiteController {
    private final IUniversiteService iUniversiteService;
    @GetMapping
    public List<Universite> retrieveAllUniversities() {
        return iUniversiteService.retrieveAllUniversities();
    }

    @PostMapping
    public Universite addUniversite(@RequestBody Universite u) {
        return iUniversiteService.addUniversite(u);
    }

    @PutMapping
    public Universite updateUniversite(@RequestBody Universite u) {
        return iUniversiteService.updateUniversite(u);
    }

    @GetMapping("{idUniversite}")
    public Universite retrieveUniversite(@PathVariable long idUniversite) {
        return iUniversiteService.retrieveUniversite(idUniversite);
    }


}

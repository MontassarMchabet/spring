package com.example.foyer.controller;

import com.example.foyer.entity.Foyer;
import com.example.foyer.service.IFoyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("foyer")
@RequiredArgsConstructor
public class FoyerController {
    private final IFoyerService iFoyerService;
    @GetMapping
    public List<Foyer> retrieveAllFoyers() {
        return iFoyerService.retrieveAllFoyers();
    }

    @PostMapping
    public Foyer addFoyer(@RequestBody Foyer f) {
        return iFoyerService.addFoyer(f);
    }

    @PutMapping
    public Foyer updateFoyer(@RequestBody Foyer f) {
        return iFoyerService.updateFoyer(f);
    }

    @GetMapping("{idFoyer}")
    public Foyer retrieveFoyer(@PathVariable long idFoyer) {
        return iFoyerService.retrieveFoyer(idFoyer);
    }

    @DeleteMapping("{idFoyer}")
    public void removeFoyer(@PathVariable long idFoyer) {
        iFoyerService.removeFoyer(idFoyer);

    }
}

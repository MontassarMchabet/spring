package com.example.foyer.controller;

import com.example.foyer.entity.Bloc;
import com.example.foyer.service.IBlocService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bloc")
@RequiredArgsConstructor
public class BlocController {
    private final IBlocService blocService;

    @GetMapping
    public List<Bloc> retreiveAllBlocs(){
        return blocService.retrieveBlocs();

    }

    @PostMapping
    public Bloc addBloc(@RequestBody Bloc b){
        return blocService.addBloc(b);
    }

    @GetMapping("{idBloc}")
    public Bloc retrieveBloc(@PathVariable long idBloc) {
        return blocService.retrieveBloc(idBloc);
    }

    @DeleteMapping("{idBloc}")
    public void removeBloc(@PathVariable long idBloc) {
        blocService.removeBloc(idBloc);

    }

}

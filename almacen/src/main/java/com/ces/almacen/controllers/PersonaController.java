package com.ces.almacen.controllers;

import com.ces.almacen.errors.NotFoundException;
import com.ces.almacen.models.PersonaModel;
import com.ces.almacen.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @PostMapping(path = "/persona")
    public void postPersona(@RequestBody PersonaModel personaModel){
        personaService.insertPersona(personaModel);
    }

    @GetMapping(path = "/personas")
    public List<PersonaModel> getPersonas(){
        return personaService.getPersonas();
    }

    @PutMapping(path = "/persona/mail")
    public boolean putPersonaIdMail(@RequestParam(name = "id")Long id, @RequestParam(name = "mail")String mail){
        if (personaService.updatePersonaIdMail(id, mail)){
            return true;
        }
        throw new NotFoundException();
    }

    @GetMapping(path = "/persona/{id}")
    public PersonaModel getPersona(@PathVariable(name = "id")Long id){
        Optional<PersonaModel> result = personaService.getPersona(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }

    @DeleteMapping(path = "/persona/{id}")
    public PersonaModel deletePersona(@PathVariable(name = "id")Long id){
        Optional<PersonaModel> result = personaService.deletePersona(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }
}

package br.com.brunosan.restwithspringbootandjava.controllers;

import br.com.brunosan.restwithspringbootandjava.model.Person;
import br.com.brunosan.restwithspringbootandjava.services.PersonService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
    
    private final PersonService services;
    
    public PersonController(PersonService services) {
        this.services = services;
    }
    
    @RequestMapping(
        value = "/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person findById(@PathVariable(value = "id") String id) {
        return services.findById(id);
    }
}

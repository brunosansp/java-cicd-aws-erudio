package br.com.brunosan.restwithspringbootandjava.services;

import br.com.brunosan.restwithspringbootandjava.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    
    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonService.class.getName());
    
    public Person findById(String id) {
        logger.info("Finding person by id");
        
        // Temporary mock
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Bruno");
        person.setLastName("Santos");
        person.setGender("Male");
        person.setAddress("São Paulo - SP - Brasil");
        
        return person;
    }
}

package com.tutorial.relationships;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {

    @Autowired
    RegistrationService service;

    @GetMapping("/registrations")
    public List<Registration> getAllRegistration(){
        return service.getAllRegistrations();
    }

    @GetMapping("/registrations/{id}")
    public Registration getRegistrations(@PathVariable int id) {
        return service.getRegistration(id);
    }

    @PostMapping("/registrations")
    public Registration addRegistration(@RequestBody Registration registration){
        return service.addRegistration(registration);
    }

    @DeleteMapping("/registrations/{id}")
    public void deleteRegistration(@PathVariable int id){
        service.deleteRegistration(id);
    }

}

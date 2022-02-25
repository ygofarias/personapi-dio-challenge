package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//controlador que será acessado através de um api Rest
@RestController

//caminho de acesso principal da api
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    //injeção de dependencia
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    //operação http do verbo get
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

}

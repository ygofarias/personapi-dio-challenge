package one.digitalinnovation.personapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//controlador que será acessado através de um api Rest
@RestController

//caminho de acesso principal da api
@RequestMapping("/api/v1/people")
public class PersonController {

    //operação http do verbo get
    @GetMapping
    public String getBook(){
        return "API Test!";
    }

}

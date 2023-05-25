package co.edu.uco.publiuco.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {
    @GetMapping("/dummy")
    public String dummyEndPoint(){
        return "Esto es un dummy";
    }
}

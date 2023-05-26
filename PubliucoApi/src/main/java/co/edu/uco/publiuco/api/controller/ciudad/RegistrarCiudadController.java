package co.edu.uco.publiuco.api.controller.ciudad;

import co.edu.uco.publiuco.dto.CiudadDTO;
import co.edu.uco.publiuco.service.facade.ciudad.RegistrarCiudadFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("publiuco/api/v1/ciudad")
public class RegistrarCiudadController {

    @Autowired
    private RegistrarCiudadFacade facade;

    @PostMapping
    public ResponseEntity<String> execute(@RequestBody CiudadDTO ciudad){
        facade.execute(ciudad);
        return new ResponseEntity<>("Éxito", HttpStatus.ACCEPTED);
    }
}

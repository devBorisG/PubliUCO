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

    @GetMapping("/dummy")
    public String hola(){
        return "hola";
    }

    @PostMapping
    public ResponseEntity<String> execute(@RequestBody CiudadDTO ciudad){
        // TODO: Validators de integridad a los datos, se lo puedo hacer en "Service" o aqui en la entrada
        // En "Service" se hacen validators de integridad del objeto de dominio
        // Aqui es tipo de dato, etc.
        facade.execute(ciudad);
        return new ResponseEntity<>("Éxito", HttpStatus.ACCEPTED);
    }
}

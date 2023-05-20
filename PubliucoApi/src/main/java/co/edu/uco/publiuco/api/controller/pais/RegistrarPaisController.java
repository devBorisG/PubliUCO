package co.edu.uco.publiuco.api.controller.pais;

import co.edu.uco.publiuco.dto.PaisDTO;
import co.edu.uco.publiuco.service.facade.pais.RegistrarPaisFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("publiuco/api/v1/pais")
public class RegistrarPaisController {

    @Autowired
    private RegistrarPaisFacade facade;

    @PostMapping
    public ResponseEntity<String> execute(@RequestBody PaisDTO pais){
        // TODO: Validators de integridad a los datos, se lo puedo hacer en "Service" o aqui en la entrada
        // En "Service" se hacen validators de integridad del objeto de dominio
        // Aqui es tipo de dato, etc.
        facade.execute(pais);
        return new ResponseEntity<>("Éxito", HttpStatus.ACCEPTED);
    }

}

package co.edu.uco.publiuco.api.controller.departamento;

import co.edu.uco.publiuco.dto.DepartamentoDTO;
import co.edu.uco.publiuco.service.facade.departamento.RegistrarDepartamentoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("publiuco/api/v1/departamento")
public class RegistrarDepartamentoController {

    @Autowired
    private RegistrarDepartamentoFacade facade;

    @PostMapping
    public ResponseEntity<String> execute(@RequestBody DepartamentoDTO departamento){
        // TODO: Validators de integridad a los datos, se lo puedo hacer en "Service" o aqui en la entrada
        // En "Service" se hacen validators de integridad del objeto de dominio
        // Aqui es tipo de dato, etc.
        facade.execute(departamento);
        return new ResponseEntity<>("Éxito", HttpStatus.ACCEPTED);
    }
}

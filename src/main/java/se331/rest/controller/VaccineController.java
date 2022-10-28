package se331.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import se331.rest.entity.Vaccine;
import se331.rest.service.VaccineService;
import se331.rest.util.LabMapper;

import java.util.List;

@Controller
public class VaccineController {
    @Autowired
    VaccineService vaccineService;

    @GetMapping("/vaccines")
    public ResponseEntity<?> getVaccineLists(){
        List<Vaccine> output;
        output = vaccineService.getVaccines();
        if (output != null)
            return ResponseEntity.ok(LabMapper.INSTANCE.getVaccineDTO(output));
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
    }

    @PostMapping("/vaccine")
    public ResponseEntity<?> addVaccine(@RequestBody Vaccine vaccine,@RequestParam(value = "pid",required = false)Long id){
        Vaccine output = vaccineService.save(vaccine,id);
        return ResponseEntity.ok(LabMapper.INSTANCE.getVaccineDTO(output));
    }
}

package se331.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<?> getVaccineLists(@RequestParam(value = "_limit",required = false) Integer perPage
            ,@RequestParam(value = "_page", required = false) Integer page){
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Vaccine> output;
        output = vaccineService.getVaccines(perPage,page);
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(output.getTotalElements()));
        if (output != null)
            return new ResponseEntity<>(LabMapper.INSTANCE.getVaccineDTO(output.getContent()),responseHeader,HttpStatus.OK);
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
    }

    @PostMapping("/vaccine")
    public ResponseEntity<?> addVaccine(@RequestBody Vaccine vaccine,@RequestParam(value = "pid",required = false)Long pid,@RequestParam(value = "did",required = false)Long did){
        Vaccine output = vaccineService.save(vaccine,pid,did);
        return ResponseEntity.ok(LabMapper.INSTANCE.getVaccineDTO(output));
    }
}

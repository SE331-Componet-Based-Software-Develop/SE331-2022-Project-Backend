package se331.rest.service;

import org.springframework.data.domain.Page;
import se331.rest.entity.Vaccine;

import java.util.List;

public interface VaccineService {
    Integer getVaccineSize();
    Vaccine getVaccine(Long id);
    Page<Vaccine> getVaccines(Integer pageSize, Integer page);
    Vaccine save(Vaccine vaccine,Long id,Long did);
}

package se331.rest.service;

import se331.rest.entity.Vaccine;

import java.util.List;

public interface VaccineService {
    Integer getVaccineSize();
    Vaccine getVaccine(Long id);
    List<Vaccine> getVaccines();
    Vaccine save(Vaccine vaccine,Long id);
}

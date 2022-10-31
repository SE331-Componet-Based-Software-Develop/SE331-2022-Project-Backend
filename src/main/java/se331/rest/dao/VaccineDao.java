package se331.rest.dao;

import se331.rest.entity.Vaccine;

import java.util.List;

public interface VaccineDao {
    Integer getVaccineSize();
    Vaccine getVaccine(Long id);
    List<Vaccine> getVaccines();
    Vaccine save(Vaccine vaccinem,Long id);
}

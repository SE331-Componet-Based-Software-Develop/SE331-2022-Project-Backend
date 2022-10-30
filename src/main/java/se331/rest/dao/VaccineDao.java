package se331.rest.dao;

import org.springframework.data.domain.Page;
import se331.rest.entity.Vaccine;

import java.util.List;

public interface VaccineDao {
    Integer getVaccineSize();
    Vaccine getVaccine(Long id);
    Page<Vaccine> getVaccines(Integer pageSize, Integer page);
    Vaccine save(Vaccine vaccinem,Long pid,Long did);
}

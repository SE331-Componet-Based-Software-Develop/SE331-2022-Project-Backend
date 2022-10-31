package se331.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se331.rest.dao.VaccineDao;
import se331.rest.entity.Vaccine;

import java.util.List;

@Service
public class VaccineServiceImpl implements VaccineService{
    @Autowired
    VaccineDao vaccineDao;
    @Override
    public Integer getVaccineSize() {
        return vaccineDao.getVaccineSize();
    }

    @Override
    public Vaccine getVaccine(Long id) {
        return vaccineDao.getVaccine(id);
    }

    @Override
    public List<Vaccine> getVaccines() {
        return vaccineDao.getVaccines();
    }


    @Override
    public Vaccine save(Vaccine vaccine,Long id) {
        return vaccineDao.save(vaccine,id);
    }
}

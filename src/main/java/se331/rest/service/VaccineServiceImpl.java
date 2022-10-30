package se331.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public Page<Vaccine> getVaccines(Integer pageSize, Integer page) {
        return vaccineDao.getVaccines(pageSize, page);
    }


    @Override
    public Vaccine save(Vaccine vaccine,Long pid,Long did) {
        return vaccineDao.save(vaccine,pid,did);
    }
}

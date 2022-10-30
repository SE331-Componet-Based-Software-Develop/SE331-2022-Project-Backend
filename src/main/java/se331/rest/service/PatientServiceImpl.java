package se331.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import se331.rest.dao.PatientDao;
import se331.rest.entity.Patient;
@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    PatientDao patientDao;
    @Override
    public Integer getPatientSize() {
        return patientDao.getPatientSize();
    }

    @Override
    public Page<Patient> getPatients(Integer pageSize, Integer page) {
        return patientDao.getPatients(pageSize,page);
    }

    @Override
    public Page<Patient> getPatientsVaccineNot(String NotVaccinated, Integer pageSize, Integer page) {
        return patientDao.getPatientsVaccineNot(NotVaccinated, pageSize, page);
    }

    @Override
    public Patient getPatient(Long id) {
        return patientDao.getPatient(id);
    }

    @Override
    public Patient save(Patient patient) {
        return patientDao.save(patient);
    }

    @Override
    public Page<Patient> getByDoctorId(Long doctor_id, Integer pageSize, Integer page) {
        return patientDao.getByDoctorId(doctor_id,pageSize, page);
    }
}

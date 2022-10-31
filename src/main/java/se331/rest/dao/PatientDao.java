package se331.rest.dao;

import org.springframework.data.domain.Page;
import se331.rest.entity.Patient;

public interface PatientDao {
    Integer getPatientSize();
    Page<Patient> getPatients(Integer pageSize,Integer page);
    Patient getPatient(Long id);
    Patient save(Patient patient);
    Page<Patient> getPatientsVaccineNot(String NotVaccinated,Integer pageSize, Integer page);
}

package se331.rest.service;

import org.springframework.data.domain.Page;
import se331.rest.entity.Patient;

public interface PatientService {
    Integer getPatientSize();
    Page<Patient> getPatients(Integer pageSize, Integer page);
    Page<Patient> getPatientsVaccineNot(String NotVaccinated,Integer pageSize, Integer page);
    Patient getPatient(Long id);
    Patient save(Patient patient);
    Page<Patient> getByDoctorId(Long doctor_id, Integer pageSize, Integer page);
}

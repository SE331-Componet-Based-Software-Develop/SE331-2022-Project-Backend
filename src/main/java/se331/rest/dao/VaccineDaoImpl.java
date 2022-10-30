package se331.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.rest.entity.Doctor;
import se331.rest.entity.Patient;
import se331.rest.entity.Vaccine;
import se331.rest.repository.DoctorRepository;
import se331.rest.repository.PatientRepository;
import se331.rest.repository.VaccineRepository;

import java.util.List;

@Repository
public class VaccineDaoImpl implements VaccineDao{
    @Autowired
    VaccineRepository vaccineRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public Integer getVaccineSize() {
        return Math.toIntExact(vaccineRepository.count());
    }

    @Override
    public Vaccine getVaccine(Long id) {
        return vaccineRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Vaccine> getVaccines(Integer pageSize, Integer page) {
        return vaccineRepository.findAll(PageRequest.of(page-1,pageSize));
    }

    @Override
    public Vaccine save(Vaccine vaccine,Long pid,Long did){
        Vaccine v = new Vaccine();
        Patient patient = new Patient();
        try {
            patient = patientRepository.findById(pid).orElse(null);
            v = patient.getVaccineinfo();
            if (vaccine.getVaccined_status().equals("Not vaccinated")) {
                v.setPatient(patient);
                patient.setVaccineinfo(v);
            } else if (vaccine.getVaccined_status().equals("FirstDose")) {
                v.setVaccined_status("FirstDose");
                v.setFirstdose_name(vaccine.getFirstdose_name());
                v.setFirstdose_time(vaccine.getFirstdose_time());
                v.setPatient(patient);
                patient.setVaccineinfo(v);
            } else if (vaccine.getVaccined_status().equals("SecondDose")) {
                v.setVaccined_status("SecondDose");
                v.setFirstdose_name(vaccine.getFirstdose_name());
                v.setFirstdose_time(vaccine.getFirstdose_time());
                v.setSeconddose_name(vaccine.getSeconddose_name());
                v.setSeconddose_time(vaccine.getSeconddose_time());
                v.setPatient(patient);
                patient.setVaccineinfo(v);
            }
            if (patient.getDoctor()==null){
                Doctor doctor = doctorRepository.findById(did).orElse(null);
                doctor.getPatients().add(patient);
                patient.setDoctor(doctor);
                doctorRepository.save(doctor);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("vaccine save is error");
        }
        patientRepository.save(patient);
        return vaccineRepository.save(v);
    }
}

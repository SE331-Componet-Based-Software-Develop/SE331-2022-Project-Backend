package se331.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.w3c.dom.events.Event;
import se331.rest.entity.Patient;

import javax.transaction.Transactional;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    List<Patient> findAll();
    @Modifying
    @Transactional
    @Query(value = "update patient set vaccineinfo_id = ?1 where id = ?2",nativeQuery = true)
    void AddVaccine(Long vaccineinfo_id,Long id);


    @Query("select  p from Patient p where p.vaccineinfo.vaccined_status <> ?1")
    Page<Patient> findAllByVaccineinfo_Vaccined_statusNot(String a,Pageable pageRequest);
}

package se331.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import se331.rest.entity.Doctor;

import javax.transaction.Transactional;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    List<Doctor> findAll();
    Page<Doctor> findByName(String name,Pageable pageRequest);

    @Modifying
    @Transactional
    @Query(value = "update doctor set user_id = ?1 where id = ?2",nativeQuery = true)
    void AddUser(Long user_id,Long id);
}

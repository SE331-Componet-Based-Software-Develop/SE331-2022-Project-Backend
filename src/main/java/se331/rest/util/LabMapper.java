package se331.rest.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import se331.rest.entity.*;

import javax.print.Doc;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(imports = Collectors.class)
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    PatientDTO getPatientDTO(Patient patient);
    List<PatientDTO> getPatientDTO(List<Patient> patients);
    DoctorDTO getDoctorDTO(Doctor doctor);
    List<DoctorDTO> getDoctorDTO(List<Doctor> doctors);

    CommentDTO getCommentDTO(Comment comment);
    List<CommentDTO> getCommentDTO(List<Comment> commentList);

    VaccineDTO getVaccineDTO(Vaccine vaccine);
    List<VaccineDTO> getVaccineDTO(List<Vaccine> vaccines);

    @Mapping(target = "authorities", expression = "java(patient.getUser().getAuthorities().stream().map(auth -> auth.getName().name()).collect(Collectors.toList()))")
    PatientAuthDTO getPatientAuthDTO(Patient patient);

    @Mapping(target = "authorities", expression = "java(doctor.getUser().getAuthorities().stream().map(auth -> auth.getName().name()).collect(Collectors.toList()))")
    DoctorAuthDTO getDoctorAuthDTO(Doctor doctor);
}

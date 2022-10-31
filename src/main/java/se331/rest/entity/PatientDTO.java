package se331.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    Long id;
    String name;
    String sur_name;
    String age;
    String hometown;
    VaccineDTO vaccineinfo;
    List<String> imageUrl;
    PatientDoctorDTO doctor;
    List<CommentDTO> comments = new ArrayList<>();
}

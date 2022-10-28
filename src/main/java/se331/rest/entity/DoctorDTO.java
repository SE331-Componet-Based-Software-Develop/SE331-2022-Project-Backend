package se331.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {
    Long id;
    String name;
    String sur_name;
    String age;
    String hometown;
    List<String> imageUrl;
    List<DoctorPatientDTO> patients = new ArrayList<>();
    List<CommentDTO> comments = new ArrayList<>();
}

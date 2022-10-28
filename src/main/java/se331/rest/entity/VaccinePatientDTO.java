package se331.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VaccinePatientDTO {
    Long id;
    String name;
    String sur_name;
    String age;
    String hometown;
    List<String> imageUrl;
}

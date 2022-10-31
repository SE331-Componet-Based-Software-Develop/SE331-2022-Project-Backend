package se331.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientVaccineDTO {
    Long id;
    String vaccined_status;
    String firstdose_name;
    String firstdose_time;
    String seconddose_name;
    String seconddose_time;
}

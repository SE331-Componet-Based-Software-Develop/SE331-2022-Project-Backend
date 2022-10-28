package se331.rest.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String vaccined_status;
    String firstdose_name;
    String firstdose_time;
    String seconddose_name;
    String seconddose_time;

    @OneToOne
    Patient patient;
}

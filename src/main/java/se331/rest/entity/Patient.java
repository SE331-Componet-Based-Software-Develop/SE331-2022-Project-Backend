package se331.rest.entity;

import lombok.*;
import se331.rest.security.entity.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String name;
    String sur_name;
    String age;
    String hometown;

    @OneToOne
    Vaccine vaccineinfo;

    @ElementCollection
    List<String> imageUrl;

    @ManyToOne
    Doctor doctor;

    @OneToMany
    @Builder.Default
    List<Comment> comments = new ArrayList<>();

    @OneToOne
    User user;
}

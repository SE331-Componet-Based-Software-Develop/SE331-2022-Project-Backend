package se331.rest.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jmm
 * @version 1.0
 * @date 2022/11/4 9:46
 * @email 2867405686@qq.com
 */
@Entity
public class HotelBooking {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    int roomNo;
    Date start;
    Date stop;
    int noNight;
    String record;
    @ManyToOne
    Stay stay;
    @ManyToMany
    List<Client> clients=new ArrayList<>();
}

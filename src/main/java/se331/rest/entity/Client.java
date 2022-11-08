package se331.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jmm
 * @version 1.0
 * @date 2022/11/4 9:46
 * @email 2867405686@qq.com
 */
@Entity
public class Client {
    @Id
    @Column(name = "id_1", nullable = false)
    private Long id1;
    int id;
    String name;
    String address;
    @OneToMany
    List<PlaneTicket> planeTickets=new ArrayList<>();;
    @OneToMany
    List<Stay> client=new ArrayList<>();
    @ManyToMany
    List<Stay> guest=new ArrayList<>();
    @ManyToMany
    List<HotelBooking> hotelBookings=new ArrayList<>();
}

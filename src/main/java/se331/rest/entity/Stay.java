package se331.rest.entity;

import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jmm
 * @version 1.0
 * @date 2022/11/4 9:55
 * @email 2867405686@qq.com
 */
@Entity
public class Stay {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    Date start;
    Date end;
    @OneToMany
    List<PlaneTicket> planeTickets=new ArrayList<>();
    @OneToMany
    List<HotelBooking> hotelBookings=new ArrayList<>();
    @ManyToOne
    Client client;
    @ManyToMany
    List<Client> guest=new ArrayList<>();
}

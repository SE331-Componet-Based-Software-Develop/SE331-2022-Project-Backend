package se331.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author jmm
 * @version 1.0
 * @date 2022/11/4 9:46
 * @email 2867405686@qq.com
 */
@Entity
public class PlaneTicket {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    String reference;
    @ManyToOne
    Stay stay;
    @ManyToOne
    Client client;
}

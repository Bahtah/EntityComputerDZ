package org.surantaev.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "computer_data")
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "comp_monitor")
    private String monitor;

    @Column(name = "comp_hdd")
    private int hdd;

    @Column(name = "comp_sdd")
    private int sdd;

    @Column(name = "comp_ozu")
    private int ozu;

    public Computer(String monitor, int hdd, int sdd, int ozu) {
        this.monitor = monitor;
        this.hdd = hdd;
        this.sdd = sdd;
        this.ozu = ozu;
    }
}

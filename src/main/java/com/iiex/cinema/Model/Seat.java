package com.iiex.cinema.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String seatNumber;
    private String seatType;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "showroom_id")
    private ShowRoom showRoom;

    @OneToMany(mappedBy = "seat")
    @JsonIgnore
    private Collection<Ticket> tickets;
}

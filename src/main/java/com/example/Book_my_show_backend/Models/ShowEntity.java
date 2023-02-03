package com.example.Book_my_show_backend.Models;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="shows")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ShowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate showDate;
    private LocalTime showTime;
    @CreationTimestamp
    private Date createdOn;
    @CreationTimestamp
    private Date updateOn;
    private double multiplier;

    @ManyToOne
    @JoinColumn
    private MovieEntity movie;

    @ManyToOne
    @JoinColumn
    private TheaterEntity theater;

    //list of seats
    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<ShowSeatEntity> listOfSeats;

    //list of tickets
    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<TicketEntity>listOfTickets;


}

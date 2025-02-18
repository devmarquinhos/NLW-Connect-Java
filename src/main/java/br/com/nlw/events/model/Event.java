package br.com.nlw.events.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "tbl_event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eventId;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "pretty_name", nullable = false, unique = true ,length = 50)
    private String prettyName;

    @Column(name = "location", nullable = false, length = 255)
    private String location;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;
}

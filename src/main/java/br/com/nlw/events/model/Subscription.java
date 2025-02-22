package br.com.nlw.events.model;
import br.com.nlw.events.model.Event;
import br.com.nlw.events.model.User;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "tbl_subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscription_number")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "subscribed_user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "indication_user_id", nullable = true)
    private User indication;
}

package com.microservices.clients.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_id_sequence",
            sequenceName ="customer_id_sequence"
    )
    @GeneratedValue(
            generator = "customer_id_sequence" ,
            strategy = GenerationType.SEQUENCE
    )
    private long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;

}

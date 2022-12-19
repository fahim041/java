package com.services.notification;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(
            name = "message",
            length = 1000
    )
    private String message;
    private String sender;
    private Long toCustomerId;
    private String toCustomerEmail;
    private LocalDateTime sentAt;

}

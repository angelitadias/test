package com.PbAbrilDes3.mspayment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "customerId", nullable = false)
    private Long customerId;
    @Column(name = "categoryId", nullable = false)
    private Long categoryId;
    //@Column(name = "category", nullable = false)
    //private String category;
    @Column(name = "total", nullable = false)
    private double total;
    @Column(name = "created_date", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;
}

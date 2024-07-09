package com.PbAbrilDes3.mscalculate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "rules")
public class Calculate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "category", nullable = false, unique = true)
    private String category;
    @Column(name = "parity", nullable = false)
    private int parity;
}

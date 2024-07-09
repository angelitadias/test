package com.PbAbrilDes3.mscustomer.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "cpf", nullable = false, unique = true, length = 20)
    @Size(min = 11, max = 14)
    private String cpf;
    @Column(name = "name", nullable = false)
    @Size(min = 3, max = 100)
    private String name;
    @Column(name = "gender", nullable = false, length = 20)
    @Pattern(regexp = "(?i)Masculino|Feminino", message = "Gender must be Male or Female")
    private String gender;
    @Column(name = "birthdate", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate birthdate;
    @NotBlank
    @Column(name = "email", nullable = false, unique = true, length = 100)
    @Email
    private String email;
    @Column(name = "points")
    private int points = 0;

}

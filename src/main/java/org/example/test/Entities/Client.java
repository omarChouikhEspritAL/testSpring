package org.example.test.Entities;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idClient;
    String identifiant;
    LocalDate datePremiereVisite;
    @ManyToMany(cascade = CascadeType.ALL)
    List<Menu>menuList = new ArrayList<>();


}

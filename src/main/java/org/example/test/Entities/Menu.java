package org.example.test.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idMenu;
    String libelleMenu;
    @Enumerated
    TypeMenu typeMenu;
    float prixTotal;
    @OneToMany(mappedBy = "menu")
    List<Composant>composants= new ArrayList<>();
    @ManyToMany(mappedBy = "menuList")
    List<Client>clients = new ArrayList<>();
}

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
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idRestaurant;
    String nom;
    long nbPlacesMax;
    @OneToMany(cascade = CascadeType.ALL)
    List<Menu> menuList = new ArrayList<>();
}

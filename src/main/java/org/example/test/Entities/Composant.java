package org.example.test.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Composant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idCompsant;
    String nomComposant;
    float prix;
    @ManyToOne
    Menu menu;
}

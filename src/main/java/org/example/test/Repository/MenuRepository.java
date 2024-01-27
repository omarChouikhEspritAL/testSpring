package org.example.test.Repository;

import org.example.test.Entities.Menu;
import org.example.test.Entities.TypeMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu,Long> {
    Menu findByLibelleMenu(String libelleMenu);
    List<String>findMenuByTypeMenuOrderByPrixTotalLibelleMenu(TypeMenu typeMenu);
    @Query(value = "SELECT m.libelle_menu FROM menu m WHERE " + "m.type_menu=:type ORDER BY m.prix_total",nativeQuery = true)
    List<String> methodeE(@Param("type") TypeMenu typeMenu);
}

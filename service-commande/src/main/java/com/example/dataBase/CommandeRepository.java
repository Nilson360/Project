package com.example.dataBase;

import com.example.domain.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
}

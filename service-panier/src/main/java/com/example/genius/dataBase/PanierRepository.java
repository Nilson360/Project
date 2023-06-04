package com.example.genius.dataBase;

import com.example.genius.domain.Panier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanierRepository extends JpaRepository<Panier,Long> {
}

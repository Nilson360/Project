package com.example.genius.dataBase;

import com.example.genius.domain.PanierItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanierItemsRepository extends JpaRepository<PanierItem,Long> {

}

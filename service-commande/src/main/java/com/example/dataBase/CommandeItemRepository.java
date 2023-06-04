package com.example.dataBase;

import com.example.domain.CommandeItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeItemRepository extends JpaRepository<CommandeItem,Long> {
}

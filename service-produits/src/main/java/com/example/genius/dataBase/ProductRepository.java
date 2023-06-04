package com.example.genius.dataBase;

import com.example.genius.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, Long> {

}

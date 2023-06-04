package com.example.genius.genius.dataBase;

import com.example.genius.genius.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, Long> {

}

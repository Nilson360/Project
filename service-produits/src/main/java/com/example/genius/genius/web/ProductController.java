package com.example.genius.genius.web;

import com.example.genius.genius.domain.Product;
import com.example.genius.genius.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Récupère tous les produits
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Récupère un produit par son identifiant
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product); // Renvoie le produit avec le code de réponse OK (200)
        } else {
            return ResponseEntity.notFound().build(); // Renvoie une réponse Not Found (404)
        }
    }

    // Crée un nouveau produit
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    // Met à jour un produit existant
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Product product = productService.updateProduct(id, updatedProduct);
        if (product != null) {
            return ResponseEntity.ok(product); // Renvoie le produit mis à jour avec le code de réponse OK (200)
        } else {
            return ResponseEntity.notFound().build(); // Renvoie une réponse Not Found (404)
        }
    }

    // Supprime un produit
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build(); // Renvoie une réponse sans contenu avec le code de réponse No Content (204)
    }
}

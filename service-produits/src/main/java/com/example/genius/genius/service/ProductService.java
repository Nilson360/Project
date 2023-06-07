package com.example.genius.genius.service;

import ch.qos.logback.core.net.server.Client;
import com.example.genius.genius.dataBase.ProductRepository;
import com.example.genius.genius.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final WebClient webClient;

    @Autowired
    public ProductService(ProductRepository productRepository, WebClient webClient) {
        this.productRepository = productRepository;
        this.webClient = webClient;
    }
    /**
     * Méthode de l'api
     *
     */
    // Récupère les informations du client qui a acheté un produit spécifique
    public Mono<Client> getClientByProductId(Long productId) {
        return this.webClient.get()
                .uri("http://localhost:8080/client/product/" + productId)
                .retrieve()
                .bodyToMono(Client.class);
    }

    /**
     *  Méthodes de la classe
     * @return
     */
    // Récupère tous les produits
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Supprime un produit par son identifiant
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // Met à jour un produit existant
    public Product updateProduct(Long id, Product updatedProduct) {
        Optional<Product> existingProduct = productRepository.findById(id);

        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            product.setStock(updatedProduct.getStock());
            return productRepository.save(product); // Renvoie le produit mis à jour
        } else {
            return null; // Aucun produit trouvé avec l'identifiant donné
        }
    }

    // Crée un nouveau produit
    public Product createProduct(Product product) {
        return productRepository.save(product); // Renvoie le produit créé
    }

    // Récupère un produit par son identifiant
    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null); // Renvoie le produit s'il existe, sinon renvoie null
    }
}

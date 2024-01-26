package com.example.demo.resource;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Autowired
    private ProductRepository productRepository;

    @GET
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GET
    @Path("/{id}")
    public Product getProduct(@PathParam("id") Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @POST
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @PUT
    @Path("/{id}")
    public Product updateProduct(@PathParam("id") Long id, Product updatedProduct) {
        Product existingProduct = productRepository.findById(id).orElse(null);

        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setStatus(updatedProduct.getStatus());
            existingProduct.setType(updatedProduct.getType());
            return productRepository.save(existingProduct);
        }

        return null;
    }


    @DELETE
    @Path("/{id}")
    public void deleteProduct(@PathParam("id") Long id) {
        productRepository.deleteById(id);
    }
}

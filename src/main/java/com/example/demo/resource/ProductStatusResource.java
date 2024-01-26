package com.example.demo.resource;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductStatus;
import com.example.demo.repository.ProductStatusRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Path("/productStatuses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductStatusResource {

    @Autowired
    private ProductStatusRepository productStatusRepository;

    @GET
    public List<ProductStatus> getProductStatuses() {
        return productStatusRepository.findAll();
    }

    @GET
    @Path("/{id}")
    public ProductStatus getProduct(@PathParam("id") Long id) {
        return productStatusRepository.findById(id).orElse(null);
    }

    @PUT
    @Path("/{id}")
    public ProductStatus updateProduct(@PathParam("id") Long id, ProductStatus updatedProduct) {
        ProductStatus existingProduct = productStatusRepository.findById(id).orElse(null);

        if (existingProduct != null) {
            existingProduct.setStatus(updatedProduct.getStatus());
            return productStatusRepository.save(existingProduct);
        }

        return null;
    }

    @DELETE
    @Path("/{id}")
    public void deleteProduct(@PathParam("id") Long id) {
        productStatusRepository.deleteById(id);
    }
}
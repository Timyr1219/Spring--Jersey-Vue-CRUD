package com.example.demo.resource;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductStatus;
import com.example.demo.entity.ProductType;
import com.example.demo.repository.ProductTypeRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Path("/productTypes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductTypeResource {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @GET
    public List<ProductType> getProductTypes() {
        return productTypeRepository.findAll();
    }


    @GET
    @Path("/{id}")
    public ProductType getProduct(@PathParam("id") Long id) {
        return productTypeRepository.findById(id).orElse(null);
    }

    @PUT
    @Path("/{id}")
    public ProductType updateProduct(@PathParam("id") Long id, ProductType updatedProduct) {
        ProductType existingProduct = productTypeRepository.findById(id).orElse(null);

        if (existingProduct != null) {
            existingProduct.setType(updatedProduct.getType());
            return productTypeRepository.save(existingProduct);
        }

        return null;
    }

    @DELETE
    @Path("/{id}")
    public void deleteProduct(@PathParam("id") Long id) {
        productTypeRepository.deleteById(id);
    }
}

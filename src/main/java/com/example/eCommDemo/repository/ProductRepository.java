package com.example.eCommDemo.repository;

import com.example.eCommDemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import java.util.List;
import java.util.Objects;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select\n" +
            "\tp.product_name,\n" +
            "\tp.product_desc,\n" +
            "\tp.product_price,\n" +
            "\tpa.product_color,\n" +
            "\tpa.product_size,\n" +
            "\tp.product_type,\n" +
            "\tu.name,\n" +
            "\tu.phone,\n" +
            "\tp.product_quantity \n" +
            "from\n" +
            "\tproducts p\n" +
            "join product_attr pa on\n" +
            "\tpa.product_id = p.id\n" +
            "join users u on\n" +
            "\tu.id = p.added_by\n" +
            "WHERE\n" +
            "\tp.id=:productId", nativeQuery = true)
    public List<Object> getProductsByProductId(Long productId);

    @Query(value = "select\n" +
            "\tp.product_name,\n" +
            "\tp.product_desc,\n" +
            "\tp.product_price,\n" +
            "\tpa.product_color,\n" +
            "\tpa.product_size,\n" +
            "\tp.product_type,\n" +
            "\tp.product_quantity \n" +
            "from\n" +
            "\tproducts p\n" +
            "join product_attr pa on\n" +
            "\tpa.product_id = p.id\n" +
            "WHERE\n" +
            "\tp.added_by=:id", nativeQuery = true)
    public List<Object> getProductsByUserId(Long id);

}

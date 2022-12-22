package com.example.eCommDemo.repository;

import com.example.eCommDemo.entity.ProductAttributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAttrRepository extends JpaRepository<ProductAttributes, Long> {
}

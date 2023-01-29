package com.onlinemarket.inventary.repository;

import com.onlinemarket.inventary.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}

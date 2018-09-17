package com.poc.ms.cart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poc.ms.cart.model.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {

}

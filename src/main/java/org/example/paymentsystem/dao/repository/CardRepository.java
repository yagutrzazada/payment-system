package org.example.paymentsystem.dao.repository;

import org.example.paymentsystem.dao.entity.CardEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CardRepository extends CrudRepository<CardEntity,Long> {
    Optional<CardEntity> findByCardNumber(String cardNumber);

}

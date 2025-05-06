package org.example.paymentsystem.dao.repository;

import org.example.paymentsystem.dao.entity.TransferEntity;
import org.springframework.data.repository.CrudRepository;

public interface TransferRepository extends CrudRepository<TransferEntity,Long> {
}

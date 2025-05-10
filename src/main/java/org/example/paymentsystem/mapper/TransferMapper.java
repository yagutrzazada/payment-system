package org.example.paymentsystem.mapper;

import org.example.paymentsystem.dao.entity.TransferEntity;
import org.example.paymentsystem.model.enums.TransferStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")

public interface TransferMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "transactionId", expression = "java(java.util.UUID.randomUUID().toString())")
    @Mapping(target = "fromCard", source = "senderCardNumber")
    @Mapping(target = "toCard", source = "receiverCardNumber")
    @Mapping(target = "status", source = "transferStatus")
    TransferEntity toEntity(String senderCardNumber, String receiverCardNumber,
                            BigDecimal amount, TransferStatus transferStatus);

}

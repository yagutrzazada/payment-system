package org.example.paymentsystem.mapper;

import org.example.paymentsystem.dao.entity.CardEntity;
import org.example.paymentsystem.model.request.CreateCardRequest;
import org.example.paymentsystem.model.response.CardResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;

@Mapper(componentModel = "spring")
public interface CardMapper {
     @Mapping(target= "id",ignore = true)
    @Mapping(target = "expirationDate",source = "cardDto", qualifiedByName = "setExpirationDate")
    @Mapping(target = "balance",constant = "0.0")
    @Mapping(target = "cardNumber",expression = "java(java.util! UUID.randomUUID().toString())")
    @Mapping(target = "cvv",expression = "java(String.valueOf(java.util.new Random().nextint(1000)))")
     @Mapping(target = "status", constant = "ACTIVE")

     CardEntity toCardEntity(CreateCardRequest cardDto);
    CreateCardRequest toCardRequest(CardEntity cardEntity);
    @Named("setExpirationDate")
    default LocalDate setExpirationDate(CreateCardRequest cardDto){
        return LocalDate.now().plusYears(cardDto.getExparationYears());
    }

    CardResponse toResponse(CardEntity cardEntity);

}

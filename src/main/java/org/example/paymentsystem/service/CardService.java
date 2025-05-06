package org.example.paymentsystem.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.paymentsystem.dao.repository.CardRepository;
import org.example.paymentsystem.mapper.CardMapper;
import org.example.paymentsystem.model.request.CreateCardRequest;
import org.example.paymentsystem.model.response.CardResponse;
import org.example.paymentsystem.util.CardUtil;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class CardService {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;
    private final CardUtil cardUtil;

    @Transactional
    public void createCard(CreateCardRequest createCardRequest) {
        log.info("ActionLog.createCard.start holder name: {}", createCardRequest.getHolderName());
        var generatedCardNumber = cardUtil.generate("409858", 16);
        var entity = cardMapper.toCardEntity(createCardRequest);
        entity.setCardNumber(generatedCardNumber);
        cardRepository.save(entity);
        log.info("ActionLog.createCard.end holder name: {}", createCardRequest.getHolderName());
    }
    public CardResponse getCardResponse getCardByNumber(String cardNumber){
        log.info("ActionLog.getCardByNUmber.start");
    }
}

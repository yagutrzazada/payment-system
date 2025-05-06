package org.example.paymentsystem.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.paymentsystem.dao.repository.CardRepository;
import org.example.paymentsystem.exception.NotFoundException;
import org.example.paymentsystem.mapper.CardMapper;
import org.example.paymentsystem.model.request.CreateCardRequest;
import org.example.paymentsystem.model.response.CardResponse;
import org.example.paymentsystem.util.CardUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static org.example.paymentsystem.model.enums.ErrorMessage.CARD_NOT_FOUND;

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

    public CardResponse getCardByNumber(String cardNumber) {
        log.info("ActionLog.getCardByNUmber.start");
        var cardEntity = cardRepository.findByCardNumber(cardNumber).orElseThrow(() ->
                new NotFoundException(CARD_NOT_FOUND.getFormattedMessage(cardNumber)));
        var response = cardMapper.toResponse(cardEntity);
        log.info("ActionLog.getCardByNumber.end holder name: {}", cardEntity.getHolderName());
        return response;
    }

    public void addToBalance(String cardNumber, BigDecimal amount) {
        log.info("ActionLog.addToBalance.start card number: {}, amount: {}", cardNumber, amount);
        var cardEntity = cardRepository.findByCardNumber(cardNumber).orElseThrow(() ->
                new NotFoundException(CARD_NOT_FOUND.getFormattedMessage(cardNumber)));
        cardEntity.setBalance(cardEntity.getBalance().add(amount));
        cardRepository.save(cardEntity);
        log.info("ActionLog.increaseBalance.end card number: {}, new balance: {}", cardNumber,cardEntity.getBalance());
    }
}

package org.example.paymentsystem.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.paymentsystem.model.request.CreateCardRequest;
import org.example.paymentsystem.model.response.CardResponse;
import org.example.paymentsystem.service.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/v1/cards")
@RequiredArgsConstructor
public class CardController {
  private final   CardService cardService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCard(@RequestHeader(name = "Accept-Language", defaultValue = "en") String language,
                           @RequestBody @Valid CreateCardRequest createCardRequest) {
        cardService.createCard(createCardRequest);
    }

    @GetMapping("/{cardNumber}/{amount}")
    public CardResponse getCardByNumber(@PathVariable String cardNumber) {
        return cardService.getCardByNumber(cardNumber);
    }
    @PutMapping("/{cardNumber}")
    public void addToBalance(@PathVariable String cardNumber, @PathVariable BigDecimal amount){
        cardService.addToBalance(cardNumber,amount);
    }
}

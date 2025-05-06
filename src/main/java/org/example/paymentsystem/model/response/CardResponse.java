package org.example.paymentsystem.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.paymentsystem.model.enums.CardType;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardResponse {
    private String holderName;
    private String cardNumber;
    private LocalDate expirationDate;
    private String CVV;
    private CardType type;
    private BigDecimal balance;

}

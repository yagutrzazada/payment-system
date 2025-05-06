package org.example.paymentsystem.model.request;

import lombok.Data;
import org.example.paymentsystem.model.enums.CardType;

@Data
public class CreateCardRequest {
    private String holderName;
    private Integer exparationYears;
    private CardType type;
}

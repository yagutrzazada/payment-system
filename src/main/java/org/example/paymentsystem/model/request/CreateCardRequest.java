package org.example.paymentsystem.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.paymentsystem.model.enums.CardType;

@Data
public class CreateCardRequest {
    @NotBlank(message = "{holder-name.message}")
    private String holderName;
    @NotNull(message = "{expiration-years.message}")
    private Integer exparationYears;
    @NotNull(message = "{card-type.message}")
    private CardType type;
}

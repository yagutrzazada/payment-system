package org.example.paymentsystem.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.paymentsystem.model.enums.TransferStatus;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTransferRequest {
    private String senderCardNumber;
    private String receiverCardNumber;
    private BigDecimal amount;

}

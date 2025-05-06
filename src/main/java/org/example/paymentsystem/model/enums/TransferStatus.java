package org.example.paymentsystem.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TransferStatus {
    PENDING,
    SUCCESS,
    FAILED
}

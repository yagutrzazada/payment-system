package org.example.paymentsystem.controller;

import lombok.RequiredArgsConstructor;
import org.example.paymentsystem.model.request.CreateTransferRequest;
import org.example.paymentsystem.service.TransferService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/transfers")
@RequiredArgsConstructor
public class TransferController {
    private final TransferService transferService;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void doTransfer(@RequestBody CreateTransferRequest createTransferRequest) {
        transferService.doTransfer(createTransferRequest);
    }
}

package com.cinepolis.tokengenerator.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter @Setter
public class TokenRequestBodyModel {
    private String operation;

    private String amount;
    private String currency;
    private String paymentNumber;
    private String gatewaySecondTransactionId;
    private String redsysToken;
    private String mid;
    private String terminal;

    public TokenRequestBodyModel(){
    }

    public TokenRequestBodyModel(Map<String, Object> requestBody) {
        this.operation = (String) requestBody.get("operation");
        unpackNestedPayment(requestBody);
        unpackNestedPaymentMethod(requestBody);
    }

    @JsonProperty("payment")
    private void unpackNestedPayment(Map<String, Object> payment) {
        this.amount = (String) payment.get("amount");
        this.currency = (String) payment.get("currency");
        this.paymentNumber = (String) payment.get("paymentNumber");
        this.gatewaySecondTransactionId = (String) payment.get("gatewaySecondTransactionId");
    }

    @JsonProperty("paymentMethod")
    private void unpackNestedPaymentMethod(Map<String, Object> paymentMethod) {
        Map<String, Object> upcTokenData = (Map<String, Object>) paymentMethod.get("upcTokenData");
        this.redsysToken = (String) upcTokenData.get("RedsysToken");
        this.mid = (String) upcTokenData.get("Mid");
        this.terminal = (String) upcTokenData.get("Terminal");
    }


    public String generatedToken() {
        return operation + amount + currency + paymentNumber + gatewaySecondTransactionId + redsysToken + mid + terminal;
    }
}


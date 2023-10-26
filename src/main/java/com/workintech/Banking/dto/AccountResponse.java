package com.workintech.Banking.dto;



public record AccountResponse(long id, String accountName, double moneyAmount, CustomerResponse customerResponse) {
}

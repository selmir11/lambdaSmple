package com.c4hco.test.automation.Dto.Edi.Edi834;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreType
public class Edi834TransactionDetails {
    private List<Transaction> transactionList;
}

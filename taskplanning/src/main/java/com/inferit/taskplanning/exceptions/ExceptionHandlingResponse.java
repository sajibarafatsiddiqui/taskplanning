package com.inferit.taskplanning.exceptions;

import lombok.Data;

@Data
public class ExceptionHandlingResponse {
    private String productIdentifier;

    public ExceptionHandlingResponse(String productIdentifier){
        this.productIdentifier=productIdentifier;
    }
}

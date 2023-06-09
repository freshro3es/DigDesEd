package org.example.dto.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class StackTraceDTO<T> {

    private T data;
    private boolean success;
    private String error;

}

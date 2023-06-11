package org.example.dto.order;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Schema(description = "Class representing void controllers methods representation response")
public class StackTraceDTO<T> {

    @Schema(description = "Data transferred to the operation", example = "{\"name\": \"John\", \"age\": 23}")
    private T data;

    @Schema(description = "Boolean flag indicating if the operation was successful", example = "true")
    private boolean success;

    @Schema(description = "Error message that explains why the operation failed", example = "Invalid input format")
    private String error;

}

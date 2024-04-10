package ru.practicum.shareit.exception; // ErrorResponse additionally created

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Data;

@Data
@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private String details;
}

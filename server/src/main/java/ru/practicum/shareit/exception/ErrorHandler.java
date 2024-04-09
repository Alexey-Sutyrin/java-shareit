package ru.practicum.shareit.exception; // ErrorResponse и handleMethod argument added

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleUserValidationException(UserValidationException e) {
        log.error(e.getMessage());
        return new ErrorResponse("Validation for user failed", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage());
        return new ErrorResponse("Validation failed", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleUserNotFoundException(UserNotFoundException e) {
        log.error(e.getMessage());
        return new ErrorResponse("Search for user failed", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleItemNotFoundException(ItemNotFoundException e) {
        log.error(e.getMessage());
        return Map.of("Search for item failed", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Map<String, String> handleNotOwnerForbiddenException(NotOwnerForbiddenException e) {
        log.error(e.getMessage());
        return Map.of("User must be the owner", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> handleEmailConflictException(EmailConflictException e) {
        log.error(e.getMessage());
        return Map.of("Email conflict has occurred", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleBookingNotFoundException(BookingNotFoundException e) {
        log.error(e.getMessage());
        return Map.of("Search for booking failed", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleBookingValidationException(BookingValidationException e) {
        log.error(e.getMessage());
        return Map.of("Validation for booking failed", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleUnsupportedBookingStateException(UnsupportedBookingStateException e) {
        log.error(e.getMessage());
        return Map.of("error", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleUserAccessForbiddenException(UserAccessForbiddenException e) {
        log.error(e.getMessage());
        return Map.of("User access denied", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleCommentValidationException(CommentValidationException e) {
        log.error(e.getMessage());
        return Map.of("Validation for comment failed", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleItemRequestNotFoundException(ItemRequestNotFoundException e) {
        log.error(e.getMessage());
        return Map.of("Search for ItemRequest failed", e.getMessage());
    }
    // Added HttpStatus.INTERNAL_SERVER_ERROR using ErrorResponse
    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleUnknownException(Throwable e) {
        log.error(e.toString());
        return new ErrorResponse("Unknown error has occurred", e.getMessage());
    }
}

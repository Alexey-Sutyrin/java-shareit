package ru.practicum.shareit.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleUserValidationException(UserValidationException e) {
        log.error(e.getMessage());
        return new ErrorResponse("Validation for user failed: " + e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage());
        return new ErrorResponse("Validation failed: " + e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleUserNotFoundException(UserNotFoundException e) {
        log.error(e.getMessage());
        return new ErrorResponse("Search for user failed: " + e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleItemNotFoundException(ItemNotFoundException e) {
        log.error(e.getMessage());
        return new ErrorResponse("Search for item failed: " + e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse handleNotOwnerForbiddenException(NotOwnerForbiddenException e) {
        log.error(e.getMessage());
        return new ErrorResponse("User must be the owner: " + e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleEmailConflictException(EmailConflictException e) {
        log.error(e.getMessage());
        return new ErrorResponse("Email conflict has occurred: " + e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleBookingNotFoundException(BookingNotFoundException e) {
        log.error(e.getMessage());
        return new ErrorResponse("Search for booking failed: " + e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBookingValidationException(BookingValidationException e) {
        log.error(e.getMessage());
        return new ErrorResponse("Validation for booking failed: " + e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleUnsupportedBookingStateException(UnsupportedBookingStateException e) {
        log.error(e.getMessage());
        return new ErrorResponse("Unsupported booking state error: " + e.getMessage());
    }

    // First set code 403, but Postman tests require code 404
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleUserAccessForbiddenException(UserAccessForbiddenException e) {
        log.error(e.getMessage());
        return new ErrorResponse("User access denied: " + e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleCommentValidationException(CommentValidationException e) {
        log.error(e.getMessage());
        return new ErrorResponse("Validation for comment failed: " + e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleUnknownException(Throwable e) {
        log.error(e.getMessage());
        return new ErrorResponse("Unknown error has occurred: " + e.getMessage());
    }
}

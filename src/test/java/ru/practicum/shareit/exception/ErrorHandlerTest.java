package ru.practicum.shareit.exception; // Bound to Error Handler

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorHandlerTest {

    private ErrorHandler errorHandler = new ErrorHandler();

    @Test
    public void handleUserValidationExceptionTest() {
        UserValidationException exception = new UserValidationException("");
        ErrorResponse response = errorHandler.handleUserValidationException(exception);

        assertEquals("Validation for user failed", response.getMessage());
    }

    @Test
    public void handleUserNotFoundExceptionTest() {
        UserNotFoundException exception = new UserNotFoundException("");
        ErrorResponse response = errorHandler.handleUserNotFoundException(exception);

        assertEquals("Search for user failed", response.getMessage());
    }


    @Test
    public void handleItemNotFoundExceptionTest() {
        ItemNotFoundException exception = new ItemNotFoundException("");
        ErrorResponse response = errorHandler.handleItemNotFoundException(exception);

        assertEquals("Search for item failed", response.getMessage());
    }

    @Test
    public void handleNotOwnerForbiddenExceptionTest() {
        NotOwnerForbiddenException exception = new NotOwnerForbiddenException("");
        ErrorResponse response = errorHandler.handleNotOwnerForbiddenException(exception);

        assertEquals("User must be the owner", response.getMessage());
    }

    @Test
    public void handleEmailConflictExceptionTest() {
        EmailConflictException exception = new EmailConflictException("");
        ErrorResponse response = errorHandler.handleEmailConflictException(exception);

        assertEquals("Email conflict has occurred", response.getMessage());
    }

    @Test
    public void handleBookingNotFoundExceptionTest() {
        BookingNotFoundException exception = new BookingNotFoundException("");
        ErrorResponse response = errorHandler.handleBookingNotFoundException(exception);

        assertEquals("Search for booking failed", response.getMessage());
    }

    @Test
    public void handleBookingValidationExceptionTest() {
        BookingValidationException exception = new BookingValidationException("");
        ErrorResponse response = errorHandler.handleBookingValidationException(exception);

        assertEquals("Validation for booking failed", response.getMessage());
    }

    @Test
    public void handleUnsupportedBookingStateExceptionTest() {
        Map<String, String> response = errorHandler.handleUnsupportedBookingStateException(new UnsupportedBookingStateException(""));

        assertEquals(response, Map.of("error", ""));
    }

    @Test
    public void handleUserAccessForbiddenExceptionTest() {
        UserAccessForbiddenException exception = new UserAccessForbiddenException("");
        ErrorResponse response = errorHandler.handleUserAccessForbiddenException(exception);

        assertEquals("User access denied", response.getMessage());
    }

    @Test
    public void handleCommentValidationExceptionTest() {
        CommentValidationException exception = new CommentValidationException("");
        ErrorResponse response = errorHandler.handleCommentValidationException(exception);

        assertEquals("Validation for comment failed", response.getMessage());
    }

    @Test
    public void handleItemRequestNotFoundExceptionTest() {
        ItemRequestNotFoundException exception = new ItemRequestNotFoundException("");
        ErrorResponse response = errorHandler.handleItemRequestNotFoundException(exception);

        assertEquals("Search for ItemRequest failed", response.getMessage());
    }

    @Test
    public void handleUnknownExceptionTest() {
        Throwable exception = new Throwable("");
        ErrorResponse response = errorHandler.handleUnknownException(exception);

        assertEquals("Unknown error has occurred", response.getMessage());
    }
}

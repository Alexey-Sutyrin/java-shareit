package ru.practicum.shareit.exception; // Tests were added

import org.junit.jupiter.api.Test;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import javax.validation.constraints.PositiveOrZero;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Map;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class ErrorHandlerTest {

    private ErrorHandler errorHandler = new ErrorHandler();

    @Test
    public void handleUserValidationExceptionTest() {
        UserValidationException exception = new UserValidationException("");
        ErrorResponse response = errorHandler.handleUserValidationException(exception);
        assertEquals(response.getMessage(), "Validation for user failed");
    }

    @Test
    @PositiveOrZero
    public void handleMethodArgumentNotValidExceptionTest() {
        // Creating object MethodArgumentNotValidException with real BindingResult
        MethodArgumentNotValidException exception = createExceptionWithBindingResult();
        ErrorResponse response = errorHandler.handleMethodArgumentNotValidException(exception);
        assertEquals(response.getMessage(), "Validation failed");
    }

    private MethodArgumentNotValidException createExceptionWithBindingResult() {
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.getFieldError()).thenReturn(new FieldError("objectName", "fieldName", "validationMessage"));
        MethodParameter methodParameter = new MethodParameter(MethodArgumentNotValidException.class.getDeclaredConstructors()[0], -1);
        return new MethodArgumentNotValidException(methodParameter, bindingResult);
    }

    @Test
    public void handleUserNotFoundExceptionTest() {
        UserNotFoundException exception = new UserNotFoundException("");
        ErrorResponse response = errorHandler.handleUserNotFoundException(exception);
        assertEquals(response.getMessage(), "Search for user failed");
    }

    @Test
    public void handleItemNotFoundExceptionTest() {
        Map<String, String> response = errorHandler.handleItemNotFoundException(new ItemNotFoundException(""));

        assertEquals(response, Map.of("Search for item failed", ""));
    }

    @Test
    public void handleNotOwnerForbiddenExceptionTest() {
        Map<String, String> response = errorHandler.handleNotOwnerForbiddenException(new NotOwnerForbiddenException(""));

        assertEquals(response, Map.of("User must be the owner", ""));
    }

    @Test
    public void handleEmailConflictExceptionTest() {
        Map<String, String> response = errorHandler.handleEmailConflictException(new EmailConflictException(""));

        assertEquals(response, Map.of("Email conflict has occurred", ""));
    }

    @Test
    public void handleBookingNotFoundExceptionTest() {
        Map<String, String> response = errorHandler.handleBookingNotFoundException(new BookingNotFoundException(""));

        assertEquals(response, Map.of("Search for booking failed", ""));
    }

    @Test
    public void handleBookingValidationExceptionTest() {
        Map<String, String> response = errorHandler.handleBookingValidationException(new BookingValidationException(""));

        assertEquals(response, Map.of("Validation for booking failed", ""));
    }

    @Test
    public void handleUnsupportedBookingStateExceptionTest() {
        Map<String, String> response = errorHandler.handleUnsupportedBookingStateException(new UnsupportedBookingStateException(""));

        assertEquals(response, Map.of("error", ""));
    }

    @Test
    public void handleUserAccessForbiddenExceptionTest() {
        Map<String, String> response = errorHandler.handleUserAccessForbiddenException(new UserAccessForbiddenException(""));

        assertEquals(response, Map.of("User access denied", ""));
    }

    @Test
    public void handleCommentValidationExceptionTest() {
        Map<String, String> response = errorHandler.handleCommentValidationException(new CommentValidationException(""));

        assertEquals(response, Map.of("Validation for comment failed", ""));
    }

    @Test
    public void handleItemRequestNotFoundExceptionTest() {
        Map<String, String> response = errorHandler.handleItemRequestNotFoundException(new ItemRequestNotFoundException(""));

        assertEquals(response, Map.of("Search for ItemRequest failed", ""));
    }

    @Test
    public void handleUnknownExceptionTest() {
        Throwable exception = new Throwable("");
        ErrorResponse response = errorHandler.handleUnknownException(exception);
        assertEquals(response.getMessage(), "Unknown error has occurred");
    }
}

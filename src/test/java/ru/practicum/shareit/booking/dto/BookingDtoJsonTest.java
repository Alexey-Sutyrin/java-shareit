package ru.practicum.shareit.booking.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import ru.practicum.shareit.booking.BookingStatus;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class BookingDtoJsonTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSerializeBookingDto() throws Exception {
        // Создаем объект BookingDto
        BookingDto bookingDto = BookingDto.builder()
                .id(1L)
                .itemId(1L)
                .start(LocalDateTime.of(2024, 4, 1, 10, 0))
                .end(LocalDateTime.of(2024, 4, 2, 10, 0))
                .status(BookingStatus.CONFIRMED)
                .build();

        // Сериализуем объект в JSON
        String json = objectMapper.writeValueAsString(bookingDto);

        // Проверяем, что JSON содержит необходимые поля и значения
        assertThat(json).contains("\"id\":1");
        assertThat(json).contains("\"itemId\":1");
        assertThat(json).contains("\"start\":\"2024-04-01T10:00:00\"");
        assertThat(json).contains("\"end\":\"2024-04-02T10:00:00\"");
        assertThat(json).contains("\"status\":\"CONFIRMED\"");

        // Десериализуем JSON обратно в объект BookingDto
        BookingDto deserializedBookingDto = objectMapper.readValue(json, BookingDto.class);

        // Проверяем, что объекты равны
        assertThat(deserializedBookingDto).isEqualTo(bookingDto);
    }
}

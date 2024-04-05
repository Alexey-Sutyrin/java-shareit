/*package ru.practicum.shareit.booking.dto; - error

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import ru.practicum.shareit.booking.BookingStatus;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.user.model.User;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class BookingOutDtoJsonTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSerializeBookingOutDto() throws Exception {
        // Создаем объект BookingOutDto
        BookingOutDto bookingOutDto = BookingOutDto.builder()
                .id(1L)
                .start(LocalDateTime.of(2024, 4, 1, 10, 0))
                .end(LocalDateTime.of(2024, 4, 2, 10, 0))
                .status(BookingStatus.CONFIRMED)
                .booker(new User(1L, "TestUser", "test@example.com"))
                .build();

        // Создаем объект Item без использования конструктора с аргументами
        Item item = new Item();
        item.setId(1L);
        item.setName("TestItem");
        item.setDescription("TestDescription");
        item.setAvailable(true);

        // Устанавливаем объект Item в BookingOutDto
        bookingOutDto.setItem(item);

        // Сериализуем объект в JSON
        String json = objectMapper.writeValueAsString(bookingOutDto);

        // Проверяем, что JSON содержит необходимые поля и значения
        assertThat(json).contains("\"id\":1");
        assertThat(json).contains("\"start\":\"2024-04-01T10:00:00\"");
        assertThat(json).contains("\"end\":\"2024-04-02T10:00:00\"");
        assertThat(json).contains("\"status\":\"CONFIRMED\"");
        assertThat(json).contains("\"booker\":{\"id\":1,\"name\":\"TestUser\",\"email\":\"test@example.com\"}");
        assertThat(json).contains("\"item\":{\"id\":1,\"name\":\"TestItem\",\"description\":\"TestDescription\",\"available\":true}");

        // Десериализуем JSON обратно в объект BookingOutDto
        BookingOutDto deserializedBookingOutDto = objectMapper.readValue(json, BookingOutDto.class);

        // Проверяем, что объекты равны
        assertThat(deserializedBookingOutDto).isEqualTo(bookingOutDto);
    }
}
*/
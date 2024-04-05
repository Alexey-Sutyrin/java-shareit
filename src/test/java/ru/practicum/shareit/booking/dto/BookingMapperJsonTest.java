package ru.practicum.shareit.booking.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import ru.practicum.shareit.booking.Booking;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class BookingMapperJsonTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSerializeToBookingDto() throws Exception {
        // Создаем объект Booking
        Booking booking = new Booking();
        booking.setId(1L);
        booking.setStart(LocalDateTime.of(2024, 4, 1, 10, 0));
        booking.setEnd(LocalDateTime.of(2024, 4, 2, 10, 0));

        // Преобразуем его в объект BookingOutDto с помощью BookingMapper
        BookingOutDto bookingOutDto = BookingMapper.toBookingDto(booking);

        // Сериализуем объект BookingOutDto в JSON
        String json = objectMapper.writeValueAsString(bookingOutDto);

        // Проверяем, что JSON содержит необходимые поля и значения
        assertThat(json).contains("\"id\":1");
        assertThat(json).contains("\"start\":\"2024-04-01T10:00:00\"");
        assertThat(json).contains("\"end\":\"2024-04-02T10:00:00\"");

        // Десериализуем JSON обратно в объект BookingOutDto
        BookingOutDto deserializedBookingOutDto = objectMapper.readValue(json, BookingOutDto.class);

        // Проверяем, что объекты равны
        assertThat(deserializedBookingOutDto).isEqualTo(bookingOutDto);
    }

    @Test
    public void testSerializeListToBookingDto() throws Exception {
        // Создаем список объектов Booking
        Booking booking1 = new Booking();
        booking1.setId(1L);
        booking1.setStart(LocalDateTime.of(2024, 4, 1, 10, 0));
        booking1.setEnd(LocalDateTime.of(2024, 4, 2, 10, 0));

        Booking booking2 = new Booking();
        booking2.setId(2L);
        booking2.setStart(LocalDateTime.of(2024, 4, 3, 10, 0));
        booking2.setEnd(LocalDateTime.of(2024, 4, 4, 10, 0));

        List<Booking> bookings = Arrays.asList(booking1, booking2);

        // Преобразуем список в список объектов BookingOutDto с помощью BookingMapper
        List<BookingOutDto> bookingOutDtos = BookingMapper.mapToBookingDto(bookings);

        // Сериализуем список объектов BookingOutDto в JSON
        String json = objectMapper.writeValueAsString(bookingOutDtos);

        // Проверяем, что JSON содержит необходимые поля и значения для каждого объекта
        assertThat(json).contains("\"id\":1");
        assertThat(json).contains("\"start\":\"2024-04-01T10:00:00\"");
        assertThat(json).contains("\"end\":\"2024-04-02T10:00:00\"");
        assertThat(json).contains("\"id\":2");
        assertThat(json).contains("\"start\":\"2024-04-03T10:00:00\"");
        assertThat(json).contains("\"end\":\"2024-04-04T10:00:00\"");

        // Десериализуем JSON обратно в список объектов BookingOutDto
        List<BookingOutDto> deserializedBookingOutDtos = Arrays.asList(objectMapper.readValue(json, BookingOutDto[].class));

        // Проверяем, что списки объектов равны
        assertThat(deserializedBookingOutDtos).isEqualTo(bookingOutDtos);
    }
}

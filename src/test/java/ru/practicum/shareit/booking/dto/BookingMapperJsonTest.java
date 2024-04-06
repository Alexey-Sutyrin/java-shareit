package ru.practicum.shareit.booking.dto; //test OK

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

        Booking booking = new Booking();
        booking.setId(1L);
        booking.setStart(LocalDateTime.of(2024, 4, 1, 10, 0));
        booking.setEnd(LocalDateTime.of(2024, 4, 2, 10, 0));

        BookingOutDto bookingOutDto = BookingMapper.toBookingDto(booking);

        String json = objectMapper.writeValueAsString(bookingOutDto);

        assertThat(json).contains("\"id\":1");
        assertThat(json).contains("\"start\":\"2024-04-01T10:00:00\"");
        assertThat(json).contains("\"end\":\"2024-04-02T10:00:00\"");

        BookingOutDto deserializedBookingOutDto = objectMapper.readValue(json, BookingOutDto.class);

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

        List<BookingOutDto> bookingOutDtos = BookingMapper.mapToBookingDto(bookings);

        String json = objectMapper.writeValueAsString(bookingOutDtos);

        assertThat(json).contains("\"id\":1");
        assertThat(json).contains("\"start\":\"2024-04-01T10:00:00\"");
        assertThat(json).contains("\"end\":\"2024-04-02T10:00:00\"");
        assertThat(json).contains("\"id\":2");
        assertThat(json).contains("\"start\":\"2024-04-03T10:00:00\"");
        assertThat(json).contains("\"end\":\"2024-04-04T10:00:00\"");

        List<BookingOutDto> deserializedBookingOutDtos = Arrays.asList(objectMapper.readValue(json, BookingOutDto[].class));

        assertThat(deserializedBookingOutDtos).isEqualTo(bookingOutDtos);
    }
}

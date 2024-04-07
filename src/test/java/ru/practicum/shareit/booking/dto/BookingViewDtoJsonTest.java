package ru.practicum.shareit.booking.dto; //test OK

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class BookingViewDtoJsonTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSerializeBookingViewDto() throws Exception {

        BookingViewDto bookingViewDto = BookingViewDto.builder()
                .id(1L)
                .start(LocalDateTime.of(2024, 4, 1, 10, 0))
                .end(LocalDateTime.of(2024, 4, 2, 10, 0))
                .bookerId(1L)
                .itemId(1L)
                .build();

        String json = objectMapper.writeValueAsString(bookingViewDto);

        assertThat(json).contains("\"id\":1");
        assertThat(json).contains("\"start\":\"2024-04-01T10:00:00\"");
        assertThat(json).contains("\"end\":\"2024-04-02T10:00:00\"");
        assertThat(json).contains("\"bookerId\":1");
        assertThat(json).contains("\"itemId\":1");

        BookingViewDto deserializedBookingViewDto = objectMapper.readValue(json, BookingViewDto.class);

        assertThat(deserializedBookingViewDto).isEqualTo(bookingViewDto);
    }
}

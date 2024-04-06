package ru.practicum.shareit.request.dto; //test OK

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import ru.practicum.shareit.request.ItemRequest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class ItemRequestMapperJsonTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSerializeItemRequest() throws Exception {
        // Создаем объект ItemRequest
        ItemRequest itemRequest = new ItemRequest();
        itemRequest.setId(1L);
        itemRequest.setDescription("Test description");
        itemRequest.setCreated(LocalDateTime.of(2024, 4, 1, 10, 0));

        // Сериализуем объект в JSON
        String json = objectMapper.writeValueAsString(itemRequest);

        // Проверяем, что JSON содержит необходимые поля и значения
        assertThat(json).contains("\"id\":1");
        assertThat(json).contains("\"description\":\"Test description\"");
        assertThat(json).contains("\"created\":\"2024-04-01T10:00:00\"");

        // Десериализуем JSON обратно в объект ItemRequest
        ItemRequest deserializedItemRequest = objectMapper.readValue(json, ItemRequest.class);

        // Проверяем, что объекты равны
        assertThat(deserializedItemRequest).isEqualTo(itemRequest);
    }
}

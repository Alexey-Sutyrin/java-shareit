/*package ru.practicum.shareit.request.dto; - error 

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class ItemRequestInDtoJsonTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSerializeItemRequestInDto() throws Exception {
        // Создаем объект ItemRequestInDto
        ItemRequestInDto itemRequestInDto = new ItemRequestInDto(1L, "Test description", LocalDateTime.of(2024, 4, 1, 10, 0));

        // Сериализуем объект в JSON
        String json = objectMapper.writeValueAsString(itemRequestInDto);

        // Проверяем, что JSON содержит необходимые поля и значения
        assertThat(json).contains("\"id\":1");
        assertThat(json).contains("\"description\":\"Test description\"");
        assertThat(json).contains("\"created\":\"2024-04-01T10:00:00\"");

        // Десериализуем JSON обратно в объект ItemRequestInDto
        ItemRequestInDto deserializedItemRequestInDto = objectMapper.readValue(json, ItemRequestInDto.class);

        // Проверяем, что объекты равны
        assertThat(deserializedItemRequestInDto).isEqualTo(itemRequestInDto);
    }
}
*/
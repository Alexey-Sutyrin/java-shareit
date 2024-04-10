package ru.practicum.shareit.user.dto; //test OK

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import ru.practicum.shareit.user.model.User;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class UserMapperJsonTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSerializeUserDto() throws Exception {

        User user = new User(1L, "TestUser", "test@example.com");

        String json = objectMapper.writeValueAsString(user);

        assertThat(json).contains("\"id\":1");
        assertThat(json).contains("\"name\":\"TestUser\"");
        assertThat(json).contains("\"email\":\"test@example.com\"");

        // Десериализуем JSON обратно в объект UserDto
        UserDto deserializedUserDto = objectMapper.readValue(json, UserDto.class);

        // Проверяем, что объекты равны
        assertThat(deserializedUserDto).isEqualTo(UserMapper.toUserDto(user));
    }

    @Test
    public void testSerializeUserDtoList() throws Exception {
        // Создаем список объектов User
        List<User> userList = Arrays.asList(
                new User(1L, "TestUser1", "test1@example.com"),
                new User(2L, "TestUser2", "test2@example.com")
        );

        String json = objectMapper.writeValueAsString(UserMapper.mapToUserDto(userList));

        assertThat(json).contains("\"id\":1");
        assertThat(json).contains("\"name\":\"TestUser1\"");
        assertThat(json).contains("\"email\":\"test1@example.com\"");
        assertThat(json).contains("\"id\":2");
        assertThat(json).contains("\"name\":\"TestUser2\"");
        assertThat(json).contains("\"email\":\"test2@example.com\"");
    }
}

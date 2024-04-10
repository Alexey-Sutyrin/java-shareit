package ru.practicum.shareit.user.dto; //test OK

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class UserDtoJsonTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSerializeUserDto() throws Exception {

        UserDto userDto = UserDto.builder()
                .id(1L)
                .name("TestUser")
                .email("test@example.com")
                .build();

        String json = objectMapper.writeValueAsString(userDto);

        assertThat(json).contains("\"id\":1");
        assertThat(json).contains("\"name\":\"TestUser\"");
        assertThat(json).contains("\"email\":\"test@example.com\"");

        UserDto deserializedUserDto = objectMapper.readValue(json, UserDto.class);

        assertThat(deserializedUserDto).isEqualTo(userDto);
    }
}

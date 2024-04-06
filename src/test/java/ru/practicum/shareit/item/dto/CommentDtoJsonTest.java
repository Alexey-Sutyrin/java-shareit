package ru.practicum.shareit.item.dto; //test OK

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

@JsonTest
public class CommentDtoJsonTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSerializeCommentDto() throws Exception {
        CommentDto commentDto = CommentDto.builder()
                .id(1L)
                .text("Test comment")
                .itemId(1L)
                .authorId(1L)
                .authorName("TestAuthor")
                .created(LocalDateTime.now())
                .build();

        String json = objectMapper.writeValueAsString(commentDto);

        assertThat(json).contains("\"id\":1");
        assertThat(json).contains("\"text\":\"Test comment\"");
        assertThat(json).contains("\"itemId\":1");
        assertThat(json).contains("\"authorId\":1");
        assertThat(json).contains("\"authorName\":\"TestAuthor\"");

        CommentDto deserializedCommentDto = objectMapper.readValue(json, CommentDto.class);

        assertThat(deserializedCommentDto).isEqualTo(commentDto);
    }
}

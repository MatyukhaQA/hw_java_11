import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.JsonData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class JsonTest {
    ClassLoader cl = JsonTest.class.getClassLoader();
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void jsonParsingTest() throws IOException {

        try (InputStream is = cl.getResourceAsStream("data.json");
             InputStreamReader isr = new InputStreamReader(is)) {
            JsonData data = objectMapper.readValue(isr, JsonData.class);
            Assertions.assertEquals("Sweeney", data.firstName);
            Assertions.assertEquals("Todd", data.lastName);
            Assertions.assertEquals(23, data.age);
            Assertions.assertEquals(List.of("English","Spanish"), data.languages);
            Assertions.assertEquals(List.of("Math","Science"), data.hobbies);
        }
    }
}

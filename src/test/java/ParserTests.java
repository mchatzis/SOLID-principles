import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

public class ParserTests {

    @Test
    void Parsing_Simple_Message(){
        Collection<String> rawConversation = new ArrayList<>();
        rawConversation.add("1448470901 bob Hello there!");

        Collection<Message> expectedParsedConversation = new ArrayList<>();
        expectedParsedConversation.add(
                new Message(Instant.ofEpochSecond(1448470901),"bob", "Hello there!"));

        IParser parser = new Parser();
        Collection<Message> actualParsedConversation = parser.parse(rawConversation);

        Boolean areEqual = actualParsedConversation.equals(expectedParsedConversation);
        Assertions.assertTrue(areEqual);
    }

}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

public class Parser_UnitTests {

    @Test
    void Parsing_Simple_Message(){
        //Create input list of strings representing conversation
        Collection<String> rawConversation = new ArrayList<>();
        rawConversation.add("1448470901 bob Hello there!");

        //Create expected result of parsing the conversation
        Collection<Message> expectedParsedConversation = new ArrayList<>();
        expectedParsedConversation.add(
                new Message(Instant.ofEpochSecond(1448470901),"bob", "Hello there!"));

        //Run the function under test to get actual result
        IParser parser = new Parser();
        Collection<Message> actualParsedConversation = parser.parse(rawConversation);

        //Check if result is correct
        Boolean areEqual = actualParsedConversation.equals(expectedParsedConversation);
        Assertions.assertTrue(areEqual);
    }

}

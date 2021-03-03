import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

public class FiltererByKeyword_UnitTests {

    @Test
    void FilteringByKeyword_SimpleCase(){
        //Create input conversation
        Collection<Message> conversation = new ArrayList<>();
        conversation.add(new Message(Instant.ofEpochSecond(1448470901),"bob", "Hello there!"));
        conversation.add(new Message(Instant.ofEpochSecond(1448470905),"mike", "What up bob?"));

        //Create expected filtered conversation when filtering by keyword "Hello"
        Collection<Message> expectedFilteredConversation = new ArrayList<>();
        expectedFilteredConversation.add(new Message(Instant.ofEpochSecond(1448470901),"bob", "Hello there!"));

        //Run the function to get actual output
        IFiltererBy filtererByKeyword = new FiltererByKeyword("Hello");
        Collection<Message> actualFilteredConversation = filtererByKeyword.filterBy(conversation);

        //Check result
        Boolean identical = actualFilteredConversation.equals(expectedFilteredConversation);
        Assertions.assertTrue(identical);
    }

}

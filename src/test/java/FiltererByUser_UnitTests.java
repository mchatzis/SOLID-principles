import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

public class FiltererByUser_UnitTests {

    @Test
    void FilteringByUser_SimpleCase(){
        //First create the input conversation
        Collection<Message> conversation = new ArrayList<>();
        conversation.add(new Message(Instant.ofEpochSecond(1448470901),"bob", "Hello there!"));
        conversation.add(new Message(Instant.ofEpochSecond(1448470905),"mike", "What up bob?"));

        //Then create the expected output conversation when filtering by user:"bob"
        Collection<Message> expectedFilteredConversation = new ArrayList<>();
        expectedFilteredConversation.add(new Message(Instant.ofEpochSecond(1448470901),"bob", "Hello there!"));

        //Run the function under test to get actual output
        IFiltererBy filtererByUserBob = new FiltererByUser("bob");
        Collection<Message> actualFilteredConversation = filtererByUserBob.filterBy(conversation);

        //Check if actual == expected
        Boolean identical = actualFilteredConversation.equals(expectedFilteredConversation);
        Assertions.assertTrue(identical);
    }
}

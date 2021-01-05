import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

public class FiltererByUser_UnitTests {

    @Test
    void FilteringByUser_SimpleCase(){
        Collection<Message> conversation = new ArrayList<>();
        conversation.add(new Message(Instant.ofEpochSecond(1448470901),"bob", "Hello there!"));
        conversation.add(new Message(Instant.ofEpochSecond(1448470905),"mike", "What up bob?"));

        Collection<Message> expectedFilteredConversation = new ArrayList<>();
        expectedFilteredConversation.add(new Message(Instant.ofEpochSecond(1448470901),"bob", "Hello there!"));

        IFiltererBy filtererByUser = new FiltererByUser("bob");
        Collection<Message> actualFilteredConversation = filtererByUser.filterBy(conversation);

        Boolean identical = actualFilteredConversation.equals(expectedFilteredConversation);
        Assertions.assertTrue(identical);
    }
}

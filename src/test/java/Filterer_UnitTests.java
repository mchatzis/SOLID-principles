import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.*;

public class Filterer_UnitTests {

    @Test
    void FilterByUserAndKeyword_SimpleCase(){
        //Create the input conversation
        Collection<Message> conversation = new ArrayList<>();
        conversation.add(new Message(Instant.ofEpochSecond(1448470901),"bob", "Hello there!"));
        conversation.add(new Message(Instant.ofEpochSecond(1448470905),"mike", "What up bob?"));
        conversation.add(new Message(Instant.ofEpochSecond(1448470912),"mike", "You there mate?"));

        //Next three blocks are for the mocked expected behavior of dependencies
        //Create a mock filtererByUser
        Collection<Message> conversationFilteredByUser = new ArrayList<>();
        conversationFilteredByUser.add(new Message(Instant.ofEpochSecond(1448470905),"mike", "What up bob?"));
        conversationFilteredByUser.add(new Message(Instant.ofEpochSecond(1448470912),"mike", "You there mate?"));
        IFiltererBy mockedFiltererByUser = mock(FiltererByUser.class);
        when(mockedFiltererByUser.filterBy(conversation)).thenReturn(conversationFilteredByUser);

        //Create a mock filtererByKeyword
        Collection<Message> conversationFilteredByKeyword = new ArrayList<>();
        conversationFilteredByKeyword.add(new Message(Instant.ofEpochSecond(1448470912),"mike", "You there mate?"));
        IFiltererBy mockedFiltererByKeyword = mock(FiltererByKeyword.class);
        when(mockedFiltererByKeyword.filterBy(conversationFilteredByUser)).thenReturn(conversationFilteredByKeyword);

        //finally compose the mocks into a complete Filterer
        IFiltererBy[] mockedFiltererBys = {mockedFiltererByUser,mockedFiltererByKeyword};


        //Create the expected output conversation
        Collection<Message> expectedFilteredConversation = new ArrayList<>();
        expectedFilteredConversation.add(new Message(Instant.ofEpochSecond(1448470912),"mike", "You there mate?"));

        //Run the function under test to get the actual output conversation
        IFilterer filterer = new Filterer(mockedFiltererBys);
        Collection<Message> actualFilteredConversation = filterer.filter(conversation);

        //check if actual == expected
        Assertions.assertEquals(actualFilteredConversation,expectedFilteredConversation);
    }
}

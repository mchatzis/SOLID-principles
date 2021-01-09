import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.*;

public class Filterer_UnitTests {

    @Test
    void FilterByUserAndKeyword_SimpleCase(){
        Collection<Message> conversation = new ArrayList<>();
        conversation.add(new Message(Instant.ofEpochSecond(1448470901),"bob", "Hello there!"));
        conversation.add(new Message(Instant.ofEpochSecond(1448470905),"mike", "What up bob?"));
        conversation.add(new Message(Instant.ofEpochSecond(1448470912),"mike", "You there mate?"));

        Collection<Message> conversationFilteredByUser = new ArrayList<>();
        conversationFilteredByUser.add(new Message(Instant.ofEpochSecond(1448470905),"mike", "What up bob?"));
        conversationFilteredByUser.add(new Message(Instant.ofEpochSecond(1448470912),"mike", "You there mate?"));
        IFiltererBy mockedFiltererByUser = mock(FiltererByUser.class);
        when(mockedFiltererByUser.filterBy(conversation)).thenReturn(conversationFilteredByUser);

        Collection<Message> conversationFilteredByKeyword = new ArrayList<>();
        conversationFilteredByKeyword.add(new Message(Instant.ofEpochSecond(1448470912),"mike", "You there mate?"));
        IFiltererBy mockedFiltererByKeyword = mock(FiltererByKeyword.class);
        when(mockedFiltererByKeyword.filterBy(conversationFilteredByUser)).thenReturn(conversationFilteredByKeyword);

        IFiltererBy[] mockedFiltererBys = {mockedFiltererByUser,mockedFiltererByKeyword};

        IFilterer filterer = new Filterer(mockedFiltererBys);
        Collection<Message> actualFilteredConversation = filterer.filter(conversation);

        Collection<Message> expectedFilteredConversation = new ArrayList<>();
        expectedFilteredConversation.add(new Message(Instant.ofEpochSecond(1448470912),"mike", "You there mate?"));

        Assertions.assertEquals(actualFilteredConversation,expectedFilteredConversation);
    }
}

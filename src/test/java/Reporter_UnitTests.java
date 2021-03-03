import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

public class Reporter_UnitTests {

    @Test
    void Reporter_SimpleCase(){
        //Create input conversation
        Collection<Message> conversation = new ArrayList<>();
        conversation.add(new Message(Instant.ofEpochSecond(1448470901),"bob", "Hello there!"));
        conversation.add(new Message(Instant.ofEpochSecond(1448470905),"mike", "What up bob?"));
        conversation.add(new Message(Instant.ofEpochSecond(1448470912),"mike", "You there mate?"));

        //Create expected Report
        Collection<UserActivity> expectedUserActivityList = new ArrayList<>();
        expectedUserActivityList.add(new UserActivity("bob", 1));
        expectedUserActivityList.add(new UserActivity("mike", 2));
        Report expectedReport = new Report(expectedUserActivityList);

        //Run function on input to get actual report
        IReporter reporter = new Reporter(true);
        Report actualReport = reporter.generateReport(conversation);

        //Check result
        Boolean identical = actualReport.equals(expectedReport);
        Assertions.assertTrue(identical);
    }
}

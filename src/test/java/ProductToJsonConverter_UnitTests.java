import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

public class ProductToJsonConverter_UnitTests {

    @Test
    void ConvertProductToJson_SimpleCase() {
        //Create filtered conversation
        Collection<Message> filteredConversation = new ArrayList<>();
        filteredConversation.add(new Message(Instant.ofEpochSecond(1448470901),"bob", "Hello there!"));

        //Create report
        Collection<UserActivity> userActivityList = new ArrayList<>();
        userActivityList.add(new UserActivity("bob", 1));
        userActivityList.add(new UserActivity("mike", 1));
        Report report = new Report(userActivityList);

        //Using the above, create the Product which will be fed to the function
        Product product = new Product(filteredConversation,report);
        IConverter productToJsonConverter = new ProductToJsonConverter();

        //Run the function to obtain the actual converted JSON string
        String actualJsonString = productToJsonConverter.convert(product);

        //Create the expected result
        String expectedJsonString = "{\n" +
                "  \"filteredConversation\": [\n" +
                "    {\n" +
                "      \"timestamp\": 1448470901,\n" +
                "      \"senderId\": \"bob\",\n" +
                "      \"content\": \"Hello there!\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"report\": {\n" +
                "    \"userActivityMetric\": [\n" +
                "      {\n" +
                "        \"user\": \"bob\",\n" +
                "        \"messageFrequency\": 1\n" +
                "      },\n" +
                "      {\n" +
                "        \"user\": \"mike\",\n" +
                "        \"messageFrequency\": 1\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";

        //Check if they are the same
        Boolean correctConversion = actualJsonString.equals(expectedJsonString);
        Assertions.assertTrue(correctConversion);
    }
}

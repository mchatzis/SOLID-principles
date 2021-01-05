import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

public class ProductToJsonConverter_UnitTests {

    @Test
    void ConvertProductToJson_SimpleCase() {
        Collection<Message> filteredConversation = new ArrayList<>();
        filteredConversation.add(new Message(Instant.ofEpochSecond(1448470901),"bob", "Hello there!"));

        Collection<UserActivity> userActivityList = new ArrayList<>();
        userActivityList.add(new UserActivity("bob", 1));
        userActivityList.add(new UserActivity("mike", 1));
        Report report = new Report(userActivityList);

        Product product = new Product(filteredConversation,report);
        IConverter<Product,String> productToJsonConverter = new ProductToJsonConverter();

        String expectedJsonString = productToJsonConverter.convert(product);

        String actualJsonString = "{\n" +
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

        Boolean correctConversion = actualJsonString.equals(expectedJsonString);
        Assertions.assertTrue(correctConversion);
    }
}

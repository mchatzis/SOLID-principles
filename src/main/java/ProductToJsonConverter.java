import java.lang.reflect.Type;
import java.time.Instant;

import com.google.gson.*;

public class ProductToJsonConverter implements IConverter<Product,String>{

    public String convert(Product product) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Instant.class, new ProductToJsonConverter.InstantSerializer());

        //Fixed Bug: Disable HTML Escaping -> treat ' as normal character
        Gson g = gsonBuilder.disableHtmlEscaping().setPrettyPrinting().create();

        return g.toJson(product);
    }


    static class InstantSerializer implements JsonSerializer<Instant> {
        @Override
        public JsonElement serialize(Instant instant, Type type, JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(instant.getEpochSecond());
        }
    }

}

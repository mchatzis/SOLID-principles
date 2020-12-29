import java.util.Collection;

public class Importer implements IImporter{

    public Importer (IReader reader, IParser parser) {
        this.reader = reader;
        this.parser = parser;
    }

    public Collection<Message> importData() throws Exception{
        Collection<String> rawConversation = reader.read();
        Collection<Message> parsedConversation = parser.parse(rawConversation);
        return parsedConversation;
    }

    private IReader reader;
    private IParser parser;
}

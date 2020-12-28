import java.util.Collection;

public class Manager {

    public Manager (IReader reader, IParser parser, IProcessor processor, IExporter exporter){
        this.reader = reader;
        this.parser = parser;
        this.processor = processor;
        this.exporter = exporter;
    }

    public void doBusiness() throws Exception{
        Collection<String> lines = reader.read();
        Collection<Message> messages = parser.parse(lines);
        Product product = processor.process(messages);
        exporter.export(product);

    }

    private IReader reader;
    private IParser parser;
    private IProcessor processor;
    private IExporter exporter;
}

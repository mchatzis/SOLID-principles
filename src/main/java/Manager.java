import java.util.Collection;

public class Manager {

    public Manager (IImporter importer, IProcessor processor, IExporter exporter){
        this.importer = importer;
        this.processor = processor;
        this.exporter = exporter;
    }

    public void doBusiness() throws Exception{

        Collection<Message> messages = importer.importData();
        Product product = processor.process(messages);
        exporter.export(product);

    }

    private IImporter importer;
    private IProcessor processor;
    private IExporter exporter;
}

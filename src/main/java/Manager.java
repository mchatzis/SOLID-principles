import java.util.Collection;

public class Manager {

    public Manager (IImporter importer, IProcessor processor, IExporter exporter){
        this.importer = importer;
        this.processor = processor;
        this.exporter = exporter;
    }

    public void doBusiness(){

        try {
            Collection<Message> importedConversation = importer.importData();
            Product product = processor.process(importedConversation);
            exporter.export(product);
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(e.toString());
        }

    }

    private IImporter importer;
    private IProcessor processor;
    private IExporter exporter;
}

public class Exporter implements IExporter{

    public Exporter (IConverter converter, IWriter writer){
        this.converter = converter;
        this.writer = writer;
    }

    public void export(Product product) throws Exception {
        String convertedProcessedConversation = converter.convert(product);
        writer.write(convertedProcessedConversation);
    }

    private IConverter converter;
    private IWriter writer;

}
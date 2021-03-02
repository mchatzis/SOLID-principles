public class Exporter implements IExporter{

    public Exporter (IConverter<Product,String> converter, IWriter writer){
        this.converter = converter;
        this.writer = writer;
    }

    public void export(Product product) throws Exception {
        String convertedProcessedConversation = converter.convert(product);
        writer.write(convertedProcessedConversation);
    }

    private IConverter<Product,String> converter;
    private IWriter writer;
}

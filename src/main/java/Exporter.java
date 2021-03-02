public class Exporter implements IExporter{

    public Exporter (IConverter<Product,String> converter, IWriter writer){
        this.converter = converter;
        this.writer = writer;
    }

    public void export(Product product) throws Exception {
        String jsonConvertedProduct = converter.convert(product);
        writer.write(jsonConvertedProduct);
    }

    private IConverter<Product,String> converter;
    private IWriter writer;
}

public class Program {

    public static void main(String[] args) throws Exception{

        //First initialize the structure
        IReader reader = new TextReader ("chat.txt");
        IParser parser = new Parser();
        IImporter importer = new Importer(reader,parser);

        IFiltererBy[] filtererBys = new IFiltererBy[] {
                new FiltererByUser(null),
                new FiltererByKeyword(null)
        };
        IFilterer filterer = new Filterer(filtererBys);
        IReporter reporter = new Reporter(false);
        IProcessor processor = new Processor(filterer,reporter);

        IConverter<Product,String> converter = new ProductToJsonConverter();
        IWriter writer = new TextFileWriter("out.txt");
        IExporter exporter = new Exporter(converter,writer);

        Manager manager = new Manager(importer, processor, exporter);

        //Finally, do business.
        manager.doBusiness();
    }
}

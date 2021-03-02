public class Program {

    public static void main(String[] args) throws Exception{

        //First initialize the structure

        //Initialize the Importer
        IReader reader = new TextReader ("chat.txt");
        IParser parser = new Parser();
        IImporter importer = new Importer(reader,parser);

        //Initialize the Processor
        IFiltererBy[] filtererBys = new IFiltererBy[] {
                new FiltererByUser("bob"),
                new FiltererByKeyword("pie")
        };
        IFilterer filterer = new Filterer(filtererBys);
        IReporter reporter = new Reporter(true);
        IProcessor processor = new Processor(filterer,reporter);

        //Initialize the Exporter
        IConverter<Product,String> converter = new ProductToJsonConverter();
        IWriter writer = new TextFileWriter("out.json");
        IExporter exporter = new Exporter(converter,writer);

        //Initialize the Manager of all
        Manager manager = new Manager(importer, processor, exporter);

        //Finally, run business logic
        manager.doBusiness();
    }
}

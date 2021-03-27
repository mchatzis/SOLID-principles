public class Program {

    public static void main(String[] args){

        //First initialize the structure...

        //Initialize importer (composed of a reader and a parser)
        IReader reader = new TextReader ("chat.txt");
        IParser parser = new Parser();
        IImporter importer = new Importer(reader,parser);

        //Initialize processor (composed of a filterer and a processor)
        IFiltererBy[] filtererBys = new IFiltererBy[] {
                new FiltererByUser("bob"),
                new FiltererByKeyword("you")
        };

        IFilterer filterer = new Filterer(filtererBys);
        IReporter reporter = new Reporter(true);
        IProcessor processor = new Processor(filterer,reporter);

        //Initialize exporter (composed of a converter and a writer)
        IConverter converter = new ProductToJsonConverter();
        IWriter writer = new TextFileWriter("out.json");
        IExporter exporter = new Exporter(converter,writer);

        Manager manager = new Manager(importer, processor, exporter);

        //Then, do business.
        manager.doBusiness();
    }
}

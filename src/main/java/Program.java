import java.util.Collection;

public class Program {

    public static void Main(String[] args) throws Exception{

        //First initialize the structure
        IReader reader = new TextReader ("chat.txt");
        IParser parser = new Parser();
        IImporter importer = new Importer(reader,parser);

        IFiltererBy[] filtererBys = new IFiltererBy[] {
                new FiltererByUser(null),
                new FiltererByKeyword(null)
        };
        IFilterer filterer = new Filterer(filtererBys);


    }
}

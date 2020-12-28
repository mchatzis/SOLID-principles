import java.util.Collection;

public class SimpleProcessor implements IProcessor{

    public SimpleProcessor();
    public Product process(Collection<Message> conversation) {

    }

    private IFilterer filterer;
    private IReporter reporter;
}

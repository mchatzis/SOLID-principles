import java.util.Collection;

public class Processor implements IProcessor{

    public Processor(IFilterer filterer,IReporter reporter){
        this.filterer = filterer;
        this.reporter = reporter;
    };

    public Product process(Collection<Message> conversation) {

        Collection<Message> filteredConversation = filterer.filter(conversation);
        Report report = reporter.generateReport(conversation);

        return new Product(filteredConversation,report);
    }

    private IFilterer filterer;
    private IReporter reporter;
}

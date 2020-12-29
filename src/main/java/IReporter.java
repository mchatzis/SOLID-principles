import java.util.Collection;

public interface IReporter {

    Report generateReport(Collection<Message> conversation);

}

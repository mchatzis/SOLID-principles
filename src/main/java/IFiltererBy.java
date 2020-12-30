import java.util.Collection;

public interface IFiltererBy {

    Collection<Message> filterBy(Collection<Message> conversation);

}

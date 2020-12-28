import java.util.Collection;

public interface IProcessor {
    Product process(Collection<Message> conversation);
}

import java.util.Collection;

public interface IParser {
    Collection<Message> parse(Collection<String> inp);
}

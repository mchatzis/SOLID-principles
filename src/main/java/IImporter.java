import java.util.Collection;

public interface IImporter {

    Collection<Message> importData() throws Exception;

}

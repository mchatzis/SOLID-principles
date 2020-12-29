import java.util.Collection;

public class Product {

    public Product (Collection<Message> filteredConversation, Report report){
        this.filteredConversation = filteredConversation;
        this.report = report;
    };

    private Collection<Message> filteredConversation;
    private Report report;
}

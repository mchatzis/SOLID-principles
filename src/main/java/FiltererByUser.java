import java.util.ArrayList;
import java.util.Collection;

public class FiltererByUser implements IFiltererBy {

    public FiltererByUser(String user){
        this.user = user;
    }

    public void filterBy(Collection<Message> conversation) {

        Collection<Message> helperConversation = new ArrayList<>();

        if (this.user != null) {
            for (Message message : conversation) {
                if (message.senderId.equals(user)){
                    helperConversation.add(message);
                }
            }
            conversation = helperConversation;
        }

    }

    private String user;
}

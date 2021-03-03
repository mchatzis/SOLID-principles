import java.util.ArrayList;
import java.util.Collection;

public class FiltererByKeyword implements IFiltererBy{

    public FiltererByKeyword (String keyword){
        this.keyword = keyword;
    }

    public Collection<Message> filterBy(Collection<Message> conversation) {

        Collection<Message> filteredConversation = new ArrayList<>();

        if (this.keyword != null) {
            for (Message message : conversation) {
                if (message.content.contains(keyword)){
                    filteredConversation.add(message);
                }
            }
            return filteredConversation;
        }
        else{
            return conversation;
        }
    }

    private String keyword;
}

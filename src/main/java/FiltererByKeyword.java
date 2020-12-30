import java.util.ArrayList;
import java.util.Collection;

public class FiltererByKeyword implements IFiltererBy{

    public FiltererByKeyword (String keyword){
        this.keyword = keyword;
    }

    public Collection<Message> filterBy(Collection<Message> conversation) {

        Collection<Message> helperConversation = new ArrayList<>();

        if (this.keyword != null) {
            for (Message message : conversation) {
                if (message.content.contains(keyword)){
                    helperConversation.add(message);
                }
            }
            return helperConversation;
        }
        else{
            return conversation;
        }
    }

    private String keyword;
}

import java.util.Collection;

public class Filterer implements IFilterer {

    public Filterer(IFiltererBy[] filtererBys){
        this.filtererBys = filtererBys;
    }

    public Collection<Message> filter(Collection<Message> conversation) {
        Collection<Message> filteredConversation = conversation;

        for(IFiltererBy filtererBy : this.filtererBys){
            filteredConversation = filtererBy.filterBy(filteredConversation);
        }
        return filteredConversation;
    }

    private IFiltererBy[] filtererBys;
}

import java.util.Collection;

/*
 * Filters the conversation by all filters given, eg. by user, keyword, length etc
 * In current implementation, it does this sequentially, that is:
 * each step applies an extra filter to the already filtered conversation
 */
public class Filterer implements IFilterer {

    public Filterer(IFiltererBy[] filtererBys){
        this.filtererBys = filtererBys;
    }

    /*
     * function applying all filters sequentially
     * input conversation does not get mutated
     * new conversation is returned (the filtered one)
     */
    public Collection<Message> filter(Collection<Message> conversation) {
        Collection<Message> filteredConversation = conversation;

        //apply given filters sequentially
        for(IFiltererBy filtererBy : this.filtererBys){
            filteredConversation =  filtererBy.filterBy(filteredConversation);
        }

        return filteredConversation;
    }

    private IFiltererBy[] filtererBys;
}

import java.util.Collection;

//Filters the conversation by all filters given, eg. by user, keyword, length etc
public class Filterer implements IFilterer {

    public Filterer(IFiltererBy[] filtererBys){
        this.filtererBys = filtererBys;
    }

    //function applying all filters sequentially
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

import java.util.Collection;

public class Product {

    public Product (Collection<Message> filteredConversation, Report report){
        this.filteredConversation = filteredConversation;
        this.report = report;
    };

    @Override
    public boolean equals (Object o){

        if (o == this){
            return true;
        }

        if(o == null){
            return false;
        }

        if(o.getClass() != this.getClass()){
            return false;
        }

        Product that = (Product) o;

        if (!this.report.equals(that.report)){return false;}
        if (!this.filteredConversation.equals(that.filteredConversation)){return false;}

        return true;
    }

    private Collection<Message> filteredConversation;
    private Report report;
}

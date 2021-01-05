import java.util.Collection;

public class Product {

    public Product (Collection<Message> filteredConversation, Report report){
        this.filteredConversation = filteredConversation;
        this.report = report;
    };

    @Override
    public boolean equals (Object y){

        if (y == this){
            return true;
        }

        if(y == null){
            return false;
        }

        if(y.getClass() != this.getClass()){
            return false;
        }

        Product that = (Product) y;

        if (!this.report.equals(that.report)){return false;}
        if (!this.filteredConversation.equals(that.filteredConversation)){return false;}

        return true;
    }

    private Collection<Message> filteredConversation;
    private Report report;
}

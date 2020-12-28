import java.util.ArrayList;
import java.util.Collection;

public class TextReader implements IReader{

    public TextReader (String iFilePath){
        this.iFilePath = iFilePath;
    }

    public Collection<String> read() throws Exception {
        try{

        }
        catch(Exception e){

        }
        return new ArrayList<String>();
    }

    private String iFilePath;
}

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class TextReader implements IReader{

    public TextReader (String iFilePath){
        this.iFilePath = iFilePath;
    }

    public Collection<String> read() throws Exception {

        Collection <String> rawConversation = new ArrayList<String> ();

        try (InputStream is = new FileInputStream(this.iFilePath);
             BufferedReader r = new BufferedReader(new InputStreamReader(is)))
        {
            String line = new String();
            while((line = r.readLine()) != null){
                rawConversation.add(line);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            throw new Exception("Reading operation failed miserably.");
        }
        return rawConversation;
    }

    private String iFilePath;
}

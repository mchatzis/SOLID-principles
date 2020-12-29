import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class TextFileWriter implements IWriter{

    public TextFileWriter (String oFilePath){
        this.oFilePath = oFilePath;
    }

    public void write(String text) throws Exception{
        try(OutputStream os = new FileOutputStream(this.oFilePath);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os)))
        {
            bw.write(text);
        }
    }

    private String oFilePath;
}

import java.io.*;

public class TextFileWriter implements IWriter{

    public TextFileWriter (String oFilePath){
        this.oFilePath = oFilePath;
    }

    public void write(String text) throws Exception{
        try(OutputStream os = new FileOutputStream(this.oFilePath, false);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os)))
        {
            bw.write(text);
        }
        catch (Exception e) {
            throw new IOException("Writing to file operation failed");
        }
    }

    private String oFilePath;
}

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
        catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("The output file was not found.");
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("Output file was found, but writing to it failed.");
        }
    }

    private String oFilePath;
}

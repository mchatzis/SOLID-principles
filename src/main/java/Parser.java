import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

public class Parser implements IParser{

    public Collection<Message> parse(Collection<String> rawConversation) {

        Collection<Message> parsedConversation = new ArrayList<>();

        for (String line: rawConversation){

            //Split string in whitespaces
            String[] split = line.split(" ");
            for(int i = 3; i < split.length; i++) {
                //Conversation format is: "timestamp user content"
                //content is series of words, hence add all those up to form the message
                split[2] = split[2] + " " + split[i];
            }

            parsedConversation.add(new Message(Instant.ofEpochSecond(Long.parseUnsignedLong(split[0])), split[1], split[2]));
        }
        return parsedConversation;
    }

}

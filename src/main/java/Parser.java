import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

public class Parser implements IParser{

    public Collection<Message> parse(Collection<String> rawConversation) {

        Collection<Message> parsedConversation = new ArrayList<>();

        for (String line: rawConversation){
            String[] split = line.split(" ");
            for(int i = 3; i < split.length; i++) {
                split[2] = split[2] + " " + split[i];
            }
            Character c = '1';
            //Character c = split[0].charAt(0);
            int i = Character.digit(c,10);
            parsedConversation.add(new Message(Instant.ofEpochSecond(Long.parseUnsignedLong(split[0])), split[1], split[2]));
        }
        return parsedConversation;
    }
    
}

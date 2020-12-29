import java.time.Instant;

public class Message {

    public Message(Instant timestamp, String senderId, String content) {
        this.content = content;
        this.timestamp = timestamp;
        this.senderId = senderId;
    }

    public Instant timestamp;
    public String senderId;
    public String content;

}

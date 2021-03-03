import java.time.Instant;

public class Message {

    public Message(Instant timestamp, String senderId, String content) {
        this.content = content;
        this.timestamp = timestamp;
        this.senderId = senderId;
    }

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

        Message that = (Message) y;

        if (!this.content.equals(that.content)){return false;}
        if (!this.senderId.equals(that.senderId)){return false;}
        if (this.timestamp.compareTo(that.timestamp) != 0){return false;}
        
        return true;
    }

    public Instant timestamp;
    public String senderId;
    public String content;

}

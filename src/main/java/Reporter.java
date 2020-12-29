import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;

public class Reporter implements IReporter{

    public Report generateReport(Collection<Message> conversation) {

        AbstractMap<String,Integer> activityMap = new HashMap<String,Integer> ();

        for (Message message : conversation){
            if(activityMap.containsKey(message.senderId)){
                activityMap.put(message.senderId, activityMap.get(message.senderId) + 1);
            }
            else{
                activityMap.put(message.senderId, 0);
            }
        }
        
        return null;
    }

}

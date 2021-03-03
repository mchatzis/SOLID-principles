import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Reporter implements IReporter{

    public Reporter (Boolean isReportNeeded){
        this.isReportNeeded = isReportNeeded;
    }

    public Report generateReport(Collection<Message> conversation) {

        if (!isReportNeeded){ return null; }

        else{
            //Make all metrics
            Collection<UserActivity> userActivityMetric = makeActivityMetric(conversation);

            //make report and return it
            return new Report(userActivityMetric);
        }
    }

    /*
     * Counts the frequency of messages per user
     * Returns a Collection<UserActivity> representing this metric
     * Needs original conversation as input
     */
    private Collection<UserActivity> makeActivityMetric(Collection<Message> conversation){

        //Hash map of <senderId,frequencyOfMessages>
        HashMap<String,Integer> activityMap = new HashMap<String,Integer> ();

        //Update the hash map by iterating through the conversation
        for (Message message : conversation){
            if(activityMap.containsKey(message.senderId)){
                activityMap.put(message.senderId, activityMap.get(message.senderId) + 1);
            }
            else{
                activityMap.put(message.senderId, 1);
            }
        }

        //Create object representing the user activity metric from the hash map
        Collection<UserActivity> activityMetric = new ArrayList<>();
        for(String key : activityMap.keySet()){
            activityMetric.add(new UserActivity(key, activityMap.get(key)));
        }

        return activityMetric;
    }

    //variables
    private Boolean isReportNeeded;

}

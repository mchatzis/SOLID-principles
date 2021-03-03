import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Reporter implements IReporter{

    public Reporter (Boolean createReport){
        this.createReport = createReport;
    }

    public Report generateReport(Collection<Message> conversation) {

        if (!createReport){ return null; }

        else{
            Collection<UserActivity> userActivityMetric = makeActivityMetric(conversation);
            return new Report(userActivityMetric);
        }
    }

    private Collection<UserActivity> makeActivityMetric(Collection<Message> conversation){

        HashMap<String,Integer> activityMap = new HashMap<String,Integer> ();

        for (Message message : conversation){
            if(activityMap.containsKey(message.senderId)){
                activityMap.put(message.senderId, activityMap.get(message.senderId) + 1);
            }
            else{
                activityMap.put(message.senderId, 1);
            }
        }

        Collection<UserActivity> activityMetric = new ArrayList<>();

        for(String key : activityMap.keySet()){
            activityMetric.add(new UserActivity(key, activityMap.get(key)));
        }

        return activityMetric;
    }

    //variables
    private Boolean createReport;

}

import java.util.Collection;

public class Report {

    public Report (Collection<UserActivity> userActivityMetric){
        this.userActivityMetric = userActivityMetric;
    }

    private Collection<UserActivity> userActivityMetric;

}

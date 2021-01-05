import java.util.Collection;

public class Report {

    public Report (Collection<UserActivity> userActivityMetric){
        this.userActivityMetric = userActivityMetric;
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

        Report that = (Report) y;

        if (!this.userActivityMetric.equals(that.userActivityMetric)){return false;}

        return true;
    }

    private Collection<UserActivity> userActivityMetric;

}

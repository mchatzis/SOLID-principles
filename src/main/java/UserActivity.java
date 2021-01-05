public class UserActivity {

    public UserActivity(String user, Integer messageFrequency){
        this.user = user;
        this.messageFrequency = messageFrequency;
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

        UserActivity that = (UserActivity) y;

        if (!this.user.equals(that.user)){return false;}
        if (!this.messageFrequency.equals(that.messageFrequency)){return false;}

        return true;
    }

    private String user;
    private Integer messageFrequency;
}

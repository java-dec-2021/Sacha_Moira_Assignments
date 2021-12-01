import java.util.Date;
public class AlfredBot {

    public String basicGreeting(){
        return "Hello, lovely to see you. How are you?";
    }
    public String guestGreeting(String name, String dayPeriod){
        return "Good " + dayPeriod + " " + name +". How are you this " + dayPeriod + "?";
    }
    public String dateAnnouncement(){
        Date date = new Date();
        return "Today is " + date;
    }
    public String respondBeforeAlexis(String conversation){
        return conversation;
    }
}

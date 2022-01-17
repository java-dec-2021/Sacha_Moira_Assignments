import java.util.HashMap;

public abstract class Phone {
    private String versionNumber, carrier, name;
    private int batteryPercentage;
    private HashMap<String, String> ringTone = new HashMap<String,String>();
    public Phone(String versionNumber, int batteryPercentage, String carrier, String name, String ringTone){
        this.versionNumber = versionNumber;
        this.batteryPercentage = batteryPercentage;
        this.carrier = carrier;
        this.ringTone = setRingTone(name, ringTone);
    }
    public abstract void displayInfo();

    public void setCarrier(String carrier) {this.carrier = carrier;}
    public void setBatteryPercentage(int batteryPercentage) {this.batteryPercentage = batteryPercentage;}
    public HashMap<String, String> setRingTone(String name, String ringTone) {
       this.ringTone.put(name, ringTone );
       return this.ringTone;
    }
    public int getBatteryPercentage() {
        return this.batteryPercentage;
    }
    public String getVersionNumber(){
        return this.versionNumber;
    }
    public String getCarrier() {
        return this.carrier;
    }
    public HashMap<String, String> getRingTone() {return this.ringTone;}
}



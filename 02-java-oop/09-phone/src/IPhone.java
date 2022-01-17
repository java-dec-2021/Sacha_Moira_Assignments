public class IPhone extends Phone implements Ringable{
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String name, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, name, ringTone);
    }

    @Override
    public void displayInfo() {
        System.out.printf("Version Number: %s\n", getVersionNumber());
        System.out.printf("Battery Remaining: %d%%\n", getBatteryPercentage());
        System.out.printf("Carrier: %s\n", getCarrier());
        System.out.printf("Current Ring Tone: %s\n", getRingTone().keySet());
    }
    @Override
    public String ring(String tone) {
        return getRingTone().get(tone);
    }

    @Override
    public String unlock() {
        return "Facial Recognition";
    }
}

package ru.netology;

public class Radio {
    private int radioStationNumber;
    private int volume;
    private final Switch radioStationSwitch;
    private final Switch volumeSwitch;

    public Radio() {
        this.radioStationSwitch = new CyclicSwitch(5, 0, 10);
        this.radioStationNumber = this.radioStationSwitch.getPosition();
        this.volumeSwitch = new LimitedSwitch(5, 0, 11);
        this.volume = this.volumeSwitch.getPosition();
    }

    public void next() {
        this.radioStationSwitch.next();
        this.radioStationNumber = this.radioStationSwitch.getPosition();
    }

    public void prev() {
        this.radioStationSwitch.prev();
        this.radioStationNumber = this.radioStationSwitch.getPosition();
    }

    public void volumeUp() {
        this.volumeSwitch.next();
        this.volume = this.volumeSwitch.getPosition();
    }

    public void volumeDown() {
        this.volumeSwitch.prev();
        this.volume = this.volumeSwitch.getPosition();
    }

    @Override
    public String toString() {
        return "Radio{" +
                "radioStationNumber=" + this.radioStationNumber +
                ", volume=" + this.volume +
                '}';
    }

    public int getVolume() {
        return this.volume;
    }

    public int getRadioStationNumber() {
        return this.radioStationNumber;
    }

    public void setRadioStationNumber(int radioStationNumber) {
        this.radioStationSwitch.setPosition(radioStationNumber);
        this.radioStationNumber = this.radioStationSwitch.getPosition();
    }
}

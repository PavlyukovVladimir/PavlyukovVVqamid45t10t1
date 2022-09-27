package ru.netology;

public class Radio {
    private final Switch radioStationSwitch;
    private final Switch volumeSwitch;

    public Radio() {
        this.radioStationSwitch = new CyclicSwitch(5, 0, 10);
        this.volumeSwitch = new LimitedSwitch(50, 0, 101);
    }

    public Radio(int radioStationCount) {
        this.radioStationSwitch = new CyclicSwitch(Math.abs(radioStationCount / 2), 0, radioStationCount);
        this.volumeSwitch = new LimitedSwitch(50, 0, 101);
    }

    public void next() {
        this.radioStationSwitch.next();
    }

    public void prev() {
        this.radioStationSwitch.prev();
    }

    public void volumeUp() {
        this.volumeSwitch.next();
    }

    public void volumeDown() {
        this.volumeSwitch.prev();
    }

    @Override
    public String toString() {
        return "Radio{" +
                "radioStationNumber=" + getRadioStationNumber() +
                ", radioStationCount=" + getRadioStationCount() +
                ", volume=" + getVolume() +
                '}';
    }

    public int getRadioStationCount() {
        return this.radioStationSwitch.getPositionsCount();
    }

    public int getVolume() {
        return this.volumeSwitch.getPosition();
    }

    public int getRadioStationNumber() {
        return this.radioStationSwitch.getPosition();
    }

    public void setRadioStationNumber(int radioStationNumber) {
        this.radioStationSwitch.setPosition(radioStationNumber);
    }
}

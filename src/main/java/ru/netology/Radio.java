package ru.netology;


public class Radio {
    private int radioStationNumber = 5;
    private int radioStationsCount = 10;
    private final int minRadioStationNumber = 0;
    private final int maxVolume = 10;
    private int volume = 5;
    private final int minVolume = 0;

    public Radio() {
    }

    public void setRadioStationNumber(int radioStationNumber) {
        if (this.minRadioStationNumber <= radioStationNumber) {
            if (this.minRadioStationNumber + this.radioStationsCount - 1 >= radioStationNumber) {
                this.radioStationNumber = radioStationNumber;
            }
        }
    }

    public void next() {
        if (this.minRadioStationNumber + this.radioStationsCount - 1 > this.radioStationNumber) {
            ++this.radioStationNumber;
        } else {
            this.radioStationNumber = 0;
        }

    }

    public void prev() {
        if (this.minRadioStationNumber < this.radioStationNumber) {
            --this.radioStationNumber;
        } else {
            this.radioStationNumber = this.minRadioStationNumber + this.radioStationsCount - 1;
        }

    }

    public void volumeUp() {
        if (this.maxVolume > this.volume) {
            ++this.volume;
        }

    }

    public void volumeDown() {
        if (this.minVolume < this.volume) {
            --this.volume;
        }

    }

    public String toString() {
        int radioStationNumber = this.getRadioStationNumber();
        int volume = this.getVolume();
        return "Radio(radioStationNumber=" + radioStationNumber + ", radioStationsCount=" + this.radioStationsCount + ", minRadioStationNumber=" + this.minRadioStationNumber + ", maxVolume=" + this.maxVolume + ", volume=" + volume + ", minVolume=" + this.minVolume + ")";
    }

    public int getRadioStationNumber() {
        return this.radioStationNumber;
    }

    public int getVolume() {
        return this.volume;
    }
}

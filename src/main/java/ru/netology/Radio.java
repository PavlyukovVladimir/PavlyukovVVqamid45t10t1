package ru.netology;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString(includeFieldNames = true)
@NoArgsConstructor
public class Radio {
    @Getter
    private int radioStationNumber = 5;
    private int radioStationsCount = 10;
    private final int minRadioStationNumber = 0;

    private final int maxVolume = 100;
    @Getter
    private int volume = 50;
    private final int minVolume = 0;

    public Radio(int radioStationsCount) {
        radioStationsCount = Math.abs(radioStationsCount);
        if (radioStationsCount == 0) {
            radioStationsCount = 1;
        }
        this.radioStationsCount = radioStationsCount;
        this.radioStationNumber = radioStationsCount / 2;
    }

    public void setRadioStationNumber(int radioStationNumber) {
        if (this.minRadioStationNumber > radioStationNumber) return;
        if ((this.minRadioStationNumber + this.radioStationsCount - 1) < radioStationNumber) return;
        this.radioStationNumber = radioStationNumber;
    }

    public void next() {
        if ((this.minRadioStationNumber + this.radioStationsCount - 1) > this.radioStationNumber) {
            this.radioStationNumber++;
        }else{
            this.radioStationNumber = minRadioStationNumber;
        }
    }

    public void prev() {
        if (this.minRadioStationNumber < this.radioStationNumber) {
            this.radioStationNumber--;
        }else{
            this.radioStationNumber = this.minRadioStationNumber + this.radioStationsCount - 1;
        }
    }

    public void volumeUp() {
        if (this.maxVolume > this.volume) {
            this.volume++;
        }
    }

    public void volumeDown() {
        if (this.minVolume < this.volume) {
            this.volume--;
        }
    }
}

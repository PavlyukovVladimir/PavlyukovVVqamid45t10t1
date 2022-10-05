package ru.netology;


public class Radio {
    private int radioStationNumber = 5;
    private int radioStationsCount = 10;
    private final int minRadioStationNumber = 0;
    private final int maxVolume = 100;
    private int volume = 50;
    private final int minVolume = 0;

    public Radio() {
    }

    public Radio(int radioStationsCount) {
        // в постановке задачи не было требования выкидывать ошибки на некорректное число радиостанций(должно быть не менее 1й для корректной работы)
        // по своему произволу добавил два преобразования введенного значения: отрицательного -> положительное и 0 -> 1
        
        // на случай введения отрицательного числа вычисляем модуль
        radioStationsCount = Math.abs(radioStationsCount);
        
        // если введут 0(чего не должно быть) заменяем на 1
        if (radioStationsCount == 0) {
            radioStationsCount = 1;
        }

        this.radioStationsCount = radioStationsCount;
        
        // в случае задания числа радиостанций, оставлять радиостанцию по умолчанию равной 5 опасно,
        // поэтому радиостанция по умолчанию будет примерно посередине диапазона
        this.radioStationNumber = radioStationsCount / 2;
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

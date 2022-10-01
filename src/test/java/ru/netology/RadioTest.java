package ru.netology;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты радио")
@ExtendWith(MyTestWatcher.class)
class RadioTest {

    private Radio radio;

    @BeforeEach
    void setUp(TestInfo testInfo) {
        radio = new Radio();
        System.out.println("Начинаем тест " + testInfo.getDisplayName() + ". \uD83E\uDD1E");
    }

    @ParameterizedTest(name = "{index} - {0}, нажатий {1}, ожидаем радиостанцию № {2}]")
    @CsvFileSource(files = "src/test/resources/dataNext.csv")
    @DisplayName("Параметризованный тест кнопки next")
    void next(String desc, int taps, int exp) {
        for (int i = 1; i <= taps; i++) {
            radio.next();
        }
        int expected = exp;
        int actual = radio.getRadioStationNumber();
        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "{index} - {0}, нажатий {1}, ожидаем радиостанцию № {2}]")
    @CsvFileSource(files = "src/test/resources/dataPrev.csv")
    @DisplayName("Параметризованный тест кнопки prev")
    void prev(String desc, int taps, int exp) {
        for (int i = 1; i <= taps; i++) {
            radio.prev();
        }
        int expected = exp;
        int actual = radio.getRadioStationNumber();
        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "{index} - {0}, нажатий {1}, ожидаем радиостанцию № {2}]")
    @CsvFileSource(files = "src/test/resources/dataVolumeUp.csv")
    @DisplayName("Параметризованный тест кнопки volumeUp")
    void volumeUp(String desc, int taps, int exp) {
        for (int i = 1; i <= taps; i++) {
            radio.volumeUp();
        }
        int expected = exp;
        int actual = radio.getVolume();
        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "{index} - {0}, нажатий {1}, ожидаем радиостанцию № {2}]")
    @CsvFileSource(files = "src/test/resources/dataVolumeDown.csv")
    @DisplayName("Параметризованный тест кнопки volumeDown")
    void volumeDown(String desc, int taps, int exp) {
        for (int i = 1; i <= taps; i++) {
            radio.volumeDown();
        }
        int expected = exp;
        int actual = radio.getVolume();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Тест преобразование нового объекта Radio в строку")
    void testNewRadioObjectToString() {
        String expected = "Radio(radioStationNumber=5, radioStationsCount=10, minRadioStationNumber=0, maxVolume=100, volume=50, minVolume=0)";
        String actual = radio.toString();
        assertEquals(expected, actual);
    }

    @Disabled("getVolume has been tested in the tests prev and next methods")
    @Test
    void getVolume() {
    }

    @Disabled("getRadioStationNumber has been tested in the tests volumeUp and volumeDown methods")
    @Test
    void getRadioStationNumber() {
    }

    @ParameterizedTest(name = "{index} - {0}, устанавливаем {1} радиостанцию, ожидаем радиостанцию № {2}]")
    @CsvFileSource(files = "src/test/resources/dataSetRadioStation.csv")
    @DisplayName("Параметризованный тест установки номера радиостанции")
    void setRadioStationNumber(String desc, int radioStationNumber, int exp) {
        radio.setRadioStationNumber(radioStationNumber);
        int expected = exp;
        int actual = radio.getRadioStationNumber();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Тест преобразование измененного объекта Radio в строку")
    void testChangedRadioObjectToString() {
        radio.setRadioStationNumber(7);
        radio.volumeDown();
        String expected = "Radio(radioStationNumber=7, radioStationsCount=10, minRadioStationNumber=0, maxVolume=100, volume=49, minVolume=0)";
        String actual = radio.toString();
        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "{index} - {0}, нажатий prev {1}, нажатий next {2}," +
            "число позиций переключателя {3}, ожидаемый состав параметров переключателя {4}")
    @CsvFileSource(files = "src/test/resources/dataSetRadioStationCount.csv")
    @DisplayName("Параметризованный тест функционала, назначения количества радиостанций")
    void testSetRadioStationCount(String desc, int prevCount, int nextCount, int positionsCount, String exp) {
        Radio radio = new Radio(positionsCount);
        for (int i = 1; i <= prevCount; i++) {
            radio.prev();
        }
        for (int i = 1; i <= nextCount; i++) {
            radio.next();
        }
        String expected = exp;
        String actual = radio.toString();
        assertEquals(expected, actual);
    }
}
package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
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

    @Test
    void prev() {
    }

    @Test
    void volumeUp() {
    }

    @Test
    void volumeDown() {
    }

    @Test
    void testToString() {
    }

    @Test
    void getVolume() {
    }

    @Test
    void getRadioStationNumber() {
    }

    @Test
    void setRadioStationNumber() {
    }
}
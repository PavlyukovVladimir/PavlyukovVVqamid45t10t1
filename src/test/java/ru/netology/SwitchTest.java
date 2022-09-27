package ru.netology;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class SwitchTest {
    private class TestSwitchClass extends Switch {
        public TestSwitchClass(int startPosition, int minPosition, int positionsCount) {
            super(startPosition, minPosition, positionsCount);
        }

        @Override
        public void next() {
            return;
        }

        @Override
        public void prev() {
            return;
        }

        @Override
        public String toString() {
            return String.format("{%d, %d, %d, %d}",
                    getMinPosition(), getPosition(), getMaxPosition(), getPositionsCount());
        }
    }

    private Switch testSwitchClass;

    @ParameterizedTest(name = "{index} - {0}, стартовая позиция {1}, минимальная позиция {2}," +
            "число позиций переключателя {3}, ожидаемый состав параметров переключателя {4}")
    @CsvFileSource(files = "src/test/resources/dataSwitch.csv")
    @DisplayName("Параметризованный тест проверяющий варианты создания переключателей")
    void getMaxPosition(String desc, int startPosition, int minPosition, int positionsCount, String exp) {
        testSwitchClass = new TestSwitchClass(startPosition, minPosition, positionsCount);
        String expected = exp;
        String actual = testSwitchClass.toString();
        assertEquals(expected, actual);
    }
}
package ru.netology;

public abstract class Switch {
    private final int minPosition;
    private final int positionsCount;
    private int position;

    public Switch(int startPosition, int minPosition, int positionsCount) {
        // начальная позиция при создании переключателя приоритетна
        this.position = startPosition;
        // количество позиций переключателя больше либо равно 1
        if (positionsCount == 0) {
            this.positionsCount = 1;
        } else {
            this.positionsCount = Math.abs(positionsCount);
        }
        // минимальная позиция не может быть больше начальной позиции
        if (minPosition >= startPosition) {
            this.minPosition = startPosition;
        } else {
            // минимальная позиция не может быть ниже начальной позиции далее чем число позиций переключателя
            this.minPosition = Math.max(this.position - this.positionsCount + 1, minPosition);
        }
    }

    public int getPosition() {
        return position;
    }

    public int getMinPosition() {
        return this.minPosition;
    }

    public int getPositionsCount() {
        return this.positionsCount;
    }

    public int getMaxPosition() {
        return this.minPosition + this.positionsCount - 1;
    }

    public void setPosition(int position) {
        if (position < this.minPosition) {
            return;
        }
        if (position > getMaxPosition()) {
            return;
        }
        this.position = position;
    }

    abstract public void next();

    abstract public void prev() ;

}

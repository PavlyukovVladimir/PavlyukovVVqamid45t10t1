package ru.netology;

public class LimitedSwitch extends Switch {

    public LimitedSwitch(int startPosition, int minPosition, int positionsCount) {
        super(startPosition, minPosition, positionsCount);
    }

    @Override
    public void next() {
        if ((getPosition() - getMinPosition() + 1) < getPositionsCount()) {
            setPosition(getPosition() + 1);
        }
    }

    @Override
    public void prev() {
        if ((getPosition() - getMinPosition() - 1) >= 0) {
            setPosition(getPosition() - 1);
        }
    }
}

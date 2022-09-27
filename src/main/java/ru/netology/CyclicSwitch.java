package ru.netology;

public class CyclicSwitch extends Switch {

    public CyclicSwitch(int startPosition, int minPosition, int positionsCount) {
        super(startPosition, minPosition, positionsCount);
    }

    @Override
    public void next() {
        int newPosition = getPosition() - getMinPosition() + 1;
        newPosition %= getPositionsCount();
        setPosition(getMinPosition() + newPosition);
    }

    @Override
    public void prev() {
        int newPosition = getPositionsCount() + getPosition() - getMinPosition() - 1;
        newPosition %= getPositionsCount();
        setPosition(getMinPosition() + newPosition);
    }
}

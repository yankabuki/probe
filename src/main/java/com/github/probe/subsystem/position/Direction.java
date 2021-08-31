package com.github.probe.subsystem.position;

import java.util.Arrays;
import java.util.Objects;

public enum Direction {
    LEFT("L") {
        @Override
        public void updatePosition(Navigation position) {
            position.rotateLeft();
        }
    },
    RIGHT("R") {
        @Override
        public void updatePosition(Navigation position) {
            position.rotateRight();
        }
    },
    MOVE("M") {
        @Override
        public void updatePosition(Navigation position) {
            position.moveForward();
        }
    };

    private final String command;

    Direction(String command) {
        this.command = command;
    }

    public abstract void updatePosition(Navigation position);

    public static Direction fromString(String command) {
        return Arrays.stream(Direction.values())
                .filter(x -> Objects.equals(x.command, command))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

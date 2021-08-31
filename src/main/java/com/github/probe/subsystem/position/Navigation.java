package com.github.probe.subsystem.position;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class Navigation {

    private Point position;
    private Point size;
    private String direction;

    private List<String> rrMap = Arrays.asList("N", "E", "S", "W", "N");
    private List<String> rlMap = Arrays.asList("N", "W", "S", "E", "N");
    private Map<String, Runnable> movMap = Map.of(
            "N", () -> this.position.y += 1,
            "S", () -> this.position.y -= 1,
            "W", () -> this.position.x -= 1,
            "E", () -> this.position.x += 1
            );
    private Map<String, Supplier<Boolean>> canMovMap = Map.of(
            "N", () -> this.position.y < size.y,
            "S", () -> this.position.y > 0,
            "W", () -> this.position.x > 0,
            "E", () -> this.position.x < size.x
    );

    public Navigation(Point initial, Point size, String direction) {
        this.position = initial;
        this.size = size;
        this.direction = direction;
    }

    public void rotateLeft() {
        this.direction = rlMap.get(rlMap.indexOf(direction) + 1);
    }

    public void rotateRight() {
        this.direction = rrMap.get(rrMap.indexOf(direction) + 1);
    }

    public boolean canMove() {
        return canMovMap.get(this.direction).get();
    }

    public void moveForward() {
        if(canMove()) {
            movMap.get(this.direction).run();
        }
    }

    @Override
    public String toString() {
        return String.format("%d %d %s", position.x, position.y, direction);
    }
}

package com.github.probe.subsystem.navigation;

import com.github.probe.subsystem.position.Direction;
import com.github.probe.subsystem.position.Navigation;

public class Telemetry {

    private Navigation position;

    public Telemetry(Navigation initial) {
        this.position = initial;
    }

    public void move(String command) {
       Direction direction = Direction.fromString(command);
       direction.updatePosition(position);
    }

    public String getPosition() {
        return position.toString();
    }
}

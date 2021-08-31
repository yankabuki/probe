package com.github.probe;

import com.github.probe.subsystem.navigation.Telemetry;

public class Probe {

    private Telemetry telemetry;

    public Probe(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    public void move(String direction) {
        telemetry.move(direction);
    }

    public String getPosition() {
        return telemetry.getPosition();
    }
}

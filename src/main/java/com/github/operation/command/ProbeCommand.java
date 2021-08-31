package com.github.operation.command;

import com.github.probe.Probe;
import com.github.probe.subsystem.navigation.Telemetry;
import com.github.probe.subsystem.position.Navigation;
import com.github.probe.subsystem.position.Point;

public class ProbeCommand {

    public Probe createProbe(String command, Point size) {
        String[] commands = command.split(" ");
        Point initial = new Point(Integer.parseInt(commands[0]), Integer.parseInt(commands[1]));
        String direction = commands[2];
        Navigation navigation = new Navigation(initial, size, direction);
        Telemetry telemetry = new Telemetry(navigation);
        return new Probe(telemetry);
    }

    public void receiveOrders(String command, Probe probe) {
        for(int i = 0; i < command.length(); i++) {
            probe.move(String.valueOf(command.charAt(i)));
        }
    }
}

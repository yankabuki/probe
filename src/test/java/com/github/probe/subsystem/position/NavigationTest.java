package com.github.probe.subsystem.position;

import com.github.operation.command.ProbeCommand;
import com.github.probe.Probe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NavigationTest {

    @Test
    public void shouldComputePositions() {
        ProbeCommand command = new ProbeCommand();
        Probe probe = command.createProbe("1 2 N", new Point(5, 5));
        probe.move("L");
        Assertions.assertEquals("1 2 W", probe.getPosition());
    }

    @Test
    public void shouldIgnoreInvalidPosition() {
        ProbeCommand command = new ProbeCommand();
        Probe probe = command.createProbe("0 0 W", new Point(5, 5));
        probe.move("M");
        Assertions.assertEquals("0 0 W", probe.getPosition());
    }
}
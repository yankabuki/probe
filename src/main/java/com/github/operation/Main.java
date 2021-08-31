package com.github.operation;

import com.github.operation.command.ProbeCommand;
import com.github.probe.Probe;
import com.github.probe.subsystem.position.Point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ProbeCommand probeCommand = new ProbeCommand();
        String line = br.readLine();
        String[] parts = line.split(" ");
        Point size = new Point(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
        while((line = br.readLine()) != null && !line.isBlank()) {
            Probe probe = probeCommand.createProbe(line, size);
            probeCommand.receiveOrders(br.readLine(), probe);
            System.out.println(probe.getPosition());
        }
    }
}

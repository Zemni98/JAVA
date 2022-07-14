package com.computer;

public class Laptop extends Computer implements Graphic {
	public Laptop() {
		super();

	}

	public Laptop(String name, int cpu, int memory, int battery) {
		super(name, cpu, memory, battery);
	}

	public void operate(int time) {
		super.setBattery(super.getBattery() - (time / 10));
	}

	public double rendering(int size) {
		return (double) size / (getCpu() * getMemory()) * 20;
	}

}

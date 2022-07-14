package com.computer;

public class Tab extends Computer implements Graphic {
	public Tab() {
		super();
	}

	public Tab(String name, int cpu, int memory, int battery) {
		super(name, cpu, memory, battery);
	}

	public void operate(int time) {
		super.setBattery(super.getBattery() - (time / 5));
	}

	public double rendering(int size) {
		return (double) size / (getCpu() * getMemory()) * 30;
	}

}

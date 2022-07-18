package com.computer;

public class Tab extends Computer implements Graphic  {

	
	public Tab() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tab(String name, int cpu, int memory, int battery) {
		super(name, cpu, memory, battery);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double rendering(int size) {
		// TODO Auto-generated method stub		
		return (double)size/(getCpu() * getMemory()) * 30;
	}

	@Override
	public void operate(int time) {
		// TODO Auto-generated method stub
		this.setBattery(this.getBattery() - (time / 5));
	}
		
}

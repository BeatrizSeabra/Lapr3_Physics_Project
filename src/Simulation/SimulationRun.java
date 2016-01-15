/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulation;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class SimulationRun extends Thread {

	private Boolean active;
	private Boolean pause;

	public SimulationRun(Boolean active, Boolean pause) {
		this.active = active;
		this.pause = pause;
	}

	@Override
	public void run() {
		while (this.active) {
			while (this.pause) {
			}
			System.out.println("ALGO");
			//this.stepVehicles();
			//this.stepNewVehicles();
			//this.time += this.timeStep;
		}
	}

}

package Ships;

import java.util.ArrayList;

/*
 * 1. Name of Port,
 * 2. Location of Port,
 * 3. Port Id,
 * 4. Container Capacity of Port,
 * 5. Count of ships docked at the Port,
 * 6. Count of Basic Containers,
 * 7. Count of Heavy Containers,
 * 8. Count of Liquid Containers,
 * 9. Count of Refridgerated Containers.
 */

public class Ports {
	
	String portName;
	String location;
	int portId;
	int portContainerCapacity;
	int currentContainerCount;
	int dockedShip;
	int basicContainer;
	int heavyContainers;
	int liquidContainers;
	int refridgeratedContainers;
	ArrayList<String> dockedShipName = new ArrayList<String>();
	
	Ports(){
		
	}
	
	public Ports(String name, String loc, int id, int cCap) {
		this.portName = name;
		this.location = loc;
		this.portId = id;
		this.portContainerCapacity = cCap;
		this.currentContainerCount = 80;
		this.dockedShip = 1;
		this.basicContainer = 20;
		this.heavyContainers = 20;
		this.liquidContainers = 20;
		this.refridgeratedContainers = 20;
	}

	public String getPortName() {
		return portName;
	}
	
	public void displayDetails() {
		System.out.println("Name of Port: " + portName);
		System.out.println("Port Id: " + portId);
		System.out.println(portName + " is loacted in " + location);
		System.out.println("Maximum no. of containers " + portName + " can accomodate is " + portContainerCapacity + ".");
		System.out.println("No. of Containers present currently: " + currentContainerCount);
		System.out.println("No. of Ships present here: " + dockedShip);
	}

}

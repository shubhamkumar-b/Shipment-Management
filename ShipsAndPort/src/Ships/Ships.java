package Ships;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import Ships.Main;
import containers.BasicContainers;
import containers.Containers;
import containers.HeavyContainers;
import containers.LiquidContainers;
import containers.RefridgeratedContainers;

/*
 * 1. Name of Ship,
 * 2. Size of Ship,
 * 3. Ship Id,
 * 4. Capacity of Ship(Weight),
 * 5. Current Location of Ship,
 * 6. Status of Ship.
 * 
 */
public class Ships extends Containers{
	
	String shipName;
	int shipId;
	float maxWeightCapacity;
	float currentWeight = 0;
	int registeredEntry;
	int currentCount;
	String status;
	String empty = "Empty";
	String availableToLoad = "AvailableToLoad";
	String full = "Full";
	int basicContainer;
	int heavyContainers;
	int liquidContainers;
	int refridgeratedContainers;
	String currentLocation;
	ArrayList<Containers> cont = new ArrayList<Containers>();
	
	Ships(){
		
	}
	
	public Ships(String name, int id, float maxCap) {
		this.shipName= name;
		this.shipId = id;
		this.maxWeightCapacity = maxCap;
		this.status = "Empty";
		this.currentLocation = "";
		registeredEntry++;
	}
	
	public String getShipName() {
		return shipName;
	}
	
	public void displayDetails() {
		System.out.println("Name of Ship: " + shipName);
		System.out.println("Ship Id: " + shipId);
		System.out.println("Maximum containers capacity of Ship: " + maxWeightCapacity + " containers");
		System.out.println("No. of Containers " + currentCount);
		System.out.println("Current Weight of Ship " + currentWeight);
		System.out.println("Status of Ship: " + status);
		System.out.println("Basic Containers: " + basicContainer);
	}
	
	public void loadBC(int num, ArrayList<BasicContainers> bcont, ArrayList<Ships> sh) {
		// TODO Auto-generated method stub
		int k=0;
		status = sh.get(k).status;
		currentWeight = sh.get(k).currentWeight;
		maxWeightCapacity = sh.get(k).maxWeightCapacity;
		k++;
		if(status.equals(empty) || status.equals(availableToLoad)) {
			if(currentWeight < maxWeightCapacity) {
				for(int i=0; i<num;i++) {
					if(bcont.size()>num) {
						cont.add(bcont.get(i));
						bcont.remove(i);
						currentCount++;
						currentWeight = currentWeight + bcont.get(i).getContainerWeight();
						status = availableToLoad;
					}
				}
			}else if(currentWeight == maxWeightCapacity) {
				status = full;
			}
		}else 
			System.out.println("Not Enough Space. Try to unload some of the containers from ship.");
		
	}

	public void loadHC(int num, ArrayList<HeavyContainers> hcont, ArrayList<Ships> sh) {
		// TODO Auto-generated method stub
		int k=0;
		status = sh.get(k).status;
		currentWeight = sh.get(k).currentWeight;
		maxWeightCapacity = sh.get(k).maxWeightCapacity;
		k++;
		if(status.equals(empty) || status.equals(availableToLoad)) {
			if(currentWeight < maxWeightCapacity) {
				for(int i=0; i<num;i++) {
					if(hcont.size()>num) {
						cont.add(hcont.get(i));
						hcont.remove(i);
						currentCount++;
						currentWeight = currentWeight + hcont.get(i).getContainerWeight();
						status = availableToLoad;
					}
				}
			}else if(currentWeight == maxWeightCapacity) {
				status = full;
			}
		}else 
			System.out.println("Not Enough Space. Try to unload some of the containers from ship.");
		
	}

	public void loadLC(int num, ArrayList<LiquidContainers> lcont, ArrayList<Ships> sh) {
		// TODO Auto-generated method stub
		int k=0;
		status = sh.get(k).status;
		currentWeight = sh.get(k).currentWeight;
		maxWeightCapacity = sh.get(k).maxWeightCapacity;
		k++;
		if(status.equals(empty) || status.equals(availableToLoad)) {
			if(currentWeight < maxWeightCapacity) {
				for(int i=0; i<num;i++) {
					if(lcont.size()>num) {
						cont.add(lcont.get(i));
						lcont.remove(i);
						currentCount++;
						currentWeight = currentWeight + lcont.get(i).getContainerWeight();
						status = availableToLoad;
					}
				}
			}else if(currentWeight == maxWeightCapacity) {
				status = full;
			}
		}else 
			System.out.println("Not Enough Space. Try to unload some of the containers from ship.");
		
	}

	public void loadRC(int num, ArrayList<RefridgeratedContainers> rcont, ArrayList<Ships> sh) {
		// TODO Auto-generated method stub
		int k=0;
		status = sh.get(k).status;
		currentWeight = sh.get(k).currentWeight;
		maxWeightCapacity = sh.get(k).maxWeightCapacity;
		k++;
		if(status.equals(empty) || status.equals(availableToLoad)) {
			if(currentWeight < maxWeightCapacity) {
				for(int i=0; i<num;i++) {
					if(rcont.size()>num) {
						cont.add(rcont.get(i));
						rcont.remove(i);
						currentCount++;
						currentWeight = currentWeight + rcont.get(i).getContainerWeight();
						status = availableToLoad;
					}
				}
			}else if(currentWeight == maxWeightCapacity) {
				status = full;
			}
		}else 
			System.out.println("Not Enough Space. Try to unload some of the containers from ship.");
		
	}
	
	public void unloadBC(int num, ArrayList<BasicContainers> bcont, ArrayList<Ships> sh, int ele, ArrayList<Ports> p) {
		for(int i=1;i<=num;i++) {
			sh.get(ele).basicContainer--;
			sh.get(ele).currentCount--;
			sh.get(ele).containerWeight -= bcont.get(ele).containerWeight;
			p.get(ele).basicContainer++;
			if(sh.get(ele).currentCount == 0)
				sh.get(ele).status = "Empty";
			else
				sh.get(ele).status = availableToLoad;
		}
	}
	
	public void unloadHC(int num, ArrayList<HeavyContainers> hcont, ArrayList<Ships> sh, int ele, ArrayList<Ports> p) {
		for(int i=1;i<=num;i++) {
			sh.get(ele).heavyContainers--;
			sh.get(ele).currentCount--;
			sh.get(ele).containerWeight -= hcont.get(ele).containerWeight;
			p.get(ele).heavyContainers++;
			if(sh.get(ele).currentCount == 0)
				sh.get(ele).status = "Empty";
			else
				sh.get(ele).status = availableToLoad;		}
	}
	
	public void unloadLC(int num, ArrayList<LiquidContainers> lcont, ArrayList<Ships> sh, int ele, ArrayList<Ports> p) {
		for(int i=1;i<=num;i++) {
			sh.get(ele).liquidContainers--;
			sh.get(ele).currentCount--;
			sh.get(ele).containerWeight -= lcont.get(ele).containerWeight;
			p.get(ele).liquidContainers++;
			if(sh.get(ele).currentCount == 0)
				sh.get(ele).status = "Empty";
			else
				sh.get(ele).status = availableToLoad;		}
	}
	
	public void unloadRC(int num, ArrayList<RefridgeratedContainers> rcont, ArrayList<Ships> sh, int ele, ArrayList<Ports> p) {
		for(int i=1;i<=num;i++) {
			sh.get(ele).refridgeratedContainers--;
			sh.get(ele).currentCount--;
			sh.get(ele).containerWeight -= rcont.get(ele).containerWeight;
			p.get(ele).refridgeratedContainers++;
			if(sh.get(ele).currentCount == 0)
				sh.get(ele).status = "Empty";
			else
				sh.get(ele).status = availableToLoad;		}
	}
	
	public void sailShipTo(int specified, ArrayList<Ports> p, ArrayList<Ships> sh, int in) throws InterruptedException {
		System.out.println("Currently Ship " + sh.get(in).shipName + " is at " + sh.get(in).currentLocation);
		String specifiedLoc = p.get(specified - 1).location;
		sh.get(in).currentLocation = specifiedLoc;
		System.out.println(sh.get(in).shipName + " will now sail to " + sh.get(in).currentLocation);
		Thread.sleep(5000);
		System.out.println(sh.get(in).shipName + " is sailing to " + sh.get(in).currentLocation);
		//TimeUnit.SECONDS.sleep(10);
		Thread.sleep(5000);
		System.out.println("Wait a bit more its still sailing.");
		Thread.sleep(5000);
		System.out.println("It's taking too much time to reach, might be due to bad wheather conditions.");
		Thread.sleep(3000);
		System.out.println("Ohh! It's Titanic, might be possible that it has hit an iceberg.");
		Thread.sleep(2500);
		System.out.println("Ship " + sh.get(in).shipName + ", arrived at " + p.get(specified - 1).location);
		p.get(specified-1).dockedShip++;
	}
	
}

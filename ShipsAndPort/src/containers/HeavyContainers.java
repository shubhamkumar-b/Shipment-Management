package containers;

public class HeavyContainers extends Containers{
	
	HeavyContainers(){
		
	}
	public HeavyContainers(String type, int id, float weight, int loc){
		this.containerType = type;
		this.containerId = id;
		this.containerWeight = weight;
		this.initialLoc = loc;
	}
	public float getContainerWeight() {
		return containerWeight;
	}
	
}

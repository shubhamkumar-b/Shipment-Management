package containers;

public class LiquidContainers extends Containers {
	
	LiquidContainers(){
		
	}
	public LiquidContainers(String type, int id, float weight, int loc){
		this.containerType = type;
		this.containerId = id;
		this.containerWeight = weight;
		this.initialLoc = loc;
	}
	public float getContainerWeight() {
		return containerWeight;
	}

}

package containers;

public class BasicContainers extends Containers {
	
	BasicContainers(){
		
	}
	public BasicContainers(String type, int id, float weight, int loc){
		this.containerType = type;
		this.containerId = id;
		this.containerWeight = weight;
		this.initialLoc = loc;
	}
	public float getContainerWeight() {
		return containerWeight;
	}

}

package containers;

public class RefridgeratedContainers extends Containers{
	
	RefridgeratedContainers(){
		
	}
	public RefridgeratedContainers(String type, int id, float weight, int loc){
		this.containerType = type;
		this.containerId = id;
		this.containerWeight = weight;
		this.initialLoc = loc;
	}
	public float getContainerWeight() {
		return containerWeight;
	}

}

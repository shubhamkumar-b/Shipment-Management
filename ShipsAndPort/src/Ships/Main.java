package Ships;

import java.util.ArrayList;
import java.util.Scanner;

import containers.BasicContainers;
import containers.Containers;
import containers.HeavyContainers;
import containers.LiquidContainers;
import containers.RefridgeratedContainers;

import Ships.Ships;

public class Main {
	
	static Scanner z = new Scanner(System.in);
	static ArrayList<Ships> ship = new ArrayList<Ships>();
	static ArrayList<Ports> port = new ArrayList<Ports>();
	static ArrayList<BasicContainers> bcont = new ArrayList<BasicContainers>();
	static ArrayList<HeavyContainers> hcont = new ArrayList<HeavyContainers>();
	static ArrayList<LiquidContainers> lcont = new ArrayList<LiquidContainers>();
	static ArrayList<RefridgeratedContainers> rcont = new ArrayList<RefridgeratedContainers>();
	
	public static void dShipAndPort(ArrayList<Ships> ship, ArrayList<Ports> port, ArrayList<BasicContainers> bcont, ArrayList<HeavyContainers> hcont, ArrayList<LiquidContainers> lcont, ArrayList<RefridgeratedContainers> rcont) {
				
			ship.add(new Ships("Titanic", 1, 100));
			ship.add(new Ships("Climac", 2, 300));
			ship.add(new Ships("Tile", 3, 500));
			
			port.add(new Ports("Mumbai Port", "Mumbai", 1, 800));
			port.add(new Ports("Chennai Port", "Chennai", 2, 400));
			port.add(new Ports("Vizag Port", "Visakhapatnam", 3, 1000));	
			
			for(int i=1, k=1; i<=20;i++) {
				bcont.add(new BasicContainers("Basic", i, 20, k));
				if(i%5==0) { k++; }
			}
	
			for(int i=1, k=1; i<=20;i++) {
				hcont.add(new HeavyContainers("Heavy", i, 40, k));
				if(i%5==0) { k++; }
			}
			
			for(int i=1, k=1; i<=20;i++) {
				lcont.add(new LiquidContainers("Liquid", i, 12, k));
				if(i%5==0) { k++; }
			}
			
			for(int i=1, k=1; i<=20;i++) {
				rcont.add(new RefridgeratedContainers("Refridgerated", i, 22, k));
				if(i%5==0) { k++; }
			}
		}
	
	public static void registerShip(ArrayList<Ships> ship) {
		System.out.println("Enter no. of Ships you want to register: ");
		int count = z.nextInt();
		for(int i=0;i<count;i++) {
			System.out.println("Enter the name of Ship: ");
			String shipName = z.next();
			System.out.println("Enter the shipId: ");
			int shipId = z.nextInt();
			System.out.println("Enter the maximum weight capacity of ship: ");
			float shipSizeCapacity = z.nextFloat();
			ship.add(new Ships(shipName, shipId, shipSizeCapacity));
			System.out.println("Ship, " + ship.get(i+3).getShipName() + " gets registered.");
		}
	}
	
	public static void registerPort(ArrayList<Ports> port) {
		System.out.println("Enter no. of Ports you want to register: ");
		int count = z.nextInt();
		for(int i=0;i<count;i++) {
			System.out.println("Enter the name of Port: ");
			String portName = z.next();
			z.nextLine();
			System.out.println("Enter the location of Port: ");
			String location = z.next();
			System.out.println("Enter the port Id: ");
			int portId = z.nextInt();
			System.out.println("Enter the maximum capacity of port to store containers: ");
			int portConatinerCapacity = z.nextInt();
			port.add(new Ports(portName, location, portId, portConatinerCapacity));
			port.get(i+3).dockedShip = 0;
			port.get(i+3).currentContainerCount = 0;
			System.out.println("Port, " + port.get(i+3).getPortName() + " gets registered.");
		}
	}
	
	public static void containersRegistration() {
		System.out.println("Enter type of containers you want to register in a port");
		String type = z.next();
		Ports p = new Ports();
		boolean flag = true;
		System.out.println("Enter the port Id in which you want to register the containers:");
		System.out.println("Available Ports: ");
		for(int i=0;i<port.size();i++) {
			System.out.println(port.get(i).portName + " port having ID: " + port.get(i).portId);
		}
		int pid = z.nextInt();
		while(flag) {
			if(type.equals("Basic")) {
				System.out.println("Enter no. of containers you want register.");
				int cb = z.nextInt();
				for(int i=1;i<=cb;i++) {
					bcont.add( new BasicContainers("Basic", i+20, 10, pid));
				}
				port.get(pid-1).currentContainerCount +=  cb;
				System.out.println(cb + " containers gets registered successfully.");
				System.out.println("Enter the type of other container you want to register or type 'Exit' to stop registering container.");
				type = z.next();
				continue;
			}else if(type.equals("Heavy")) {
				System.out.println("Enter no. of containers you want register.");
				int ch = z.nextInt();
				for(int i=1;i<=ch;i++) {
					hcont.add( new HeavyContainers("Heavy", i+20, 10, pid));
				}
				port.get(pid-1).currentContainerCount +=  ch;
				System.out.println(ch + " containers gets registered successfully.");
				System.out.println("Enter the type of other container you want to register or type 'Exit' to stop registering container.");				type = z.next();
				type = z.next();
				continue;
			}else if(type.equals("Liquid")) {
				System.out.println("Enter no. of containers you want register.");
				int cl = z.nextInt();
				for(int i=1;i<=cl;i++) {
					lcont.add( new LiquidContainers("Liquid", i+20, 10, pid));
				}
				port.get(pid-1).currentContainerCount +=  cl;
				System.out.println(cl + " containers gets registered successfully.");
				System.out.println("Enter the type of other container you want to register or type 'Exit' to stop registering container.");				type = z.next();
				type = z.next();
				continue;
			}else if(type.equals("Refridgerated")) {
				System.out.println("Enter no. of containers you want register.");
				int cr = z.nextInt();
				for(int i=1;i<=cr;i++) {
					rcont.add( new RefridgeratedContainers("Refridgerated", i+20, 10, pid));
				}
				port.get(pid-1).currentContainerCount +=  cr;
				System.out.println(cr + " containers gets registered successfully.");
				System.out.println("Enter the type of other container you want to register or type 'Exit' to stop registering container.");				type = z.next();
				type = z.next();
				continue;
			}else if(type.equals("Exit")) {
				System.out.println("Exiting registration of Port.");
				flag = false;
				break;
			}else {
				if(flag == false)
					System.out.println("=======================================");
				else {System.out.println("Incorrect Input"); break;}
			}
		}
		
	}
	
	public static void loadContainersToShip(int index) {
		System.out.println("Enter the type of Container you want to load: ");
		String type = z.next();
		boolean fl = true;
		Ships sh = new Ships();
		while(fl) {
			if(type.equals("Basic")) {
				System.out.println("Enter no. container you want to load: ");
				int ctb = z.nextInt();
				sh.loadBC(ctb, bcont, ship);
				if(sh.currentCount==0 || sh.currentCount > 0) {
					System.out.println(ctb + " containers successfully loaded.");
					ship.get(index).basicContainer += ctb;
					ship.get(index).currentCount += ctb;
					port.get(index).currentContainerCount -= ctb;
					ship.get(index).currentWeight += 20;
					if(ship.get(index).currentWeight<ship.get(index).maxWeightCapacity) {
						ship.get(index).status = "AvailableToLoad";
					}else if(ship.get(index).currentWeight == ship.get(index).maxWeightCapacity) {
						ship.get(index).status = "Full";
					}
					//System.out.println(ship.get(index).status);
					//System.out.println(" Incremented " + ship.get(index).basicContainer + ", " + ship.get(index).currentCount + ", " + port.get(index).currentContainerCount);
				}
				System.out.println("Enter the type of other container you want to register or type 'Exit' to stop registering container.");
				type = z.next();
			}else if(type.equals("Heavy")) {
				System.out.println("Enter no. container you want to load: ");
				int cth = z.nextInt();
				sh.loadHC(cth, hcont, ship);
				if(sh.currentCount>0) {
					System.out.println(cth + " containers successfully loaded.");
					ship.get(index).basicContainer +=cth;
					ship.get(index).currentCount += cth;
					port.get(index).currentContainerCount -= cth;
					ship.get(index).currentWeight += 40;
					if(ship.get(index).currentWeight<ship.get(index).maxWeightCapacity) {
						ship.get(index).status = "AvailableToLoad";
					}else if(ship.get(index).currentWeight == ship.get(index).maxWeightCapacity) {
						ship.get(index).status = "Full";
					}
				}
				System.out.println("Enter the type of other container you want to register or type 'Exit' to stop registering container.");
				type = z.next();
			}else if(type.equals("Liquid")) {
				System.out.println("Enter no. container you want to load: ");
				int ctl = z.nextInt();
				sh.loadLC(ctl, lcont, ship);
				if(sh.currentCount>0) {
					System.out.println(ctl + " containers successfully loaded.");
					ship.get(index).basicContainer +=ctl;
					ship.get(index).currentCount += ctl;
					port.get(index).currentContainerCount -= ctl;
					ship.get(index).currentWeight += 12;
					if(ship.get(index).currentWeight<ship.get(index).maxWeightCapacity) {
						ship.get(index).status = "AvailableToLoad";
					}else if(ship.get(index).currentWeight == ship.get(index).maxWeightCapacity) {
						ship.get(index).status = "Full";
					}
				}
				System.out.println("Enter the type of other container you want to register or type 'Exit' to stop registering container.");
				type = z.next();
			}else if(type.equals("Refridgerated")) {
				System.out.println("Enter no. container you want to load: ");
				int ctr = z.nextInt();
				sh.loadRC(ctr, rcont, ship);
				if(sh.currentCount>0) {
					System.out.println(ctr + " containers successfully loaded.");
					ship.get(index).basicContainer +=ctr;
					ship.get(index).currentCount += ctr;
					port.get(index).currentContainerCount -= ctr;
					ship.get(index).currentWeight += 22;
					if(ship.get(index).currentWeight<ship.get(index).maxWeightCapacity) {
						ship.get(index).status = "AvailableToLoad";
					}else if(ship.get(index).currentWeight == ship.get(index).maxWeightCapacity) {
						ship.get(index).status = "Full";
					}
				}
				System.out.println("Enter the type of other container you want to register or type 'Exit' to stop registering container.");
				type = z.next();
			}else if(type.equals("Exit")) {
				System.out.println("Exiting Loading of Containers:");
				fl = false;
			}else {
				if(fl == false)
					System.out.println("=======================================");
				else {
					System.out.println("Incorrect Input");
					break;
				}
			}
		}
	}
	
	public static void unloadConatinersFromShip(int index) {
		System.out.println("Ship Contains: ");
		System.out.println();
		System.out.println(ship.get(index).basicContainer + " basic containers, " + ship.get(index).heavyContainers + " heavy containers, " + ship.get(index).liquidContainers + " liquid containers, " + ship.get(index).refridgeratedContainers + " refridgerated containers are present." );
		System.out.println("Enter the type of Container you want to unload: ");
		String type = z.next();
		boolean fl = true;
		Ships sh = new Ships();
		while(fl) {
			if(type.equals("Basic")) {
				System.out.println("Enter no. container you want to unload: ");
				int ctb = z.nextInt();
				sh.unloadBC(ctb, bcont, ship, index, port);
				if(ship.get(index).basicContainer == (ship.get(index).basicContainer - ctb)) {
					System.out.println(ctb + " containers successfully unloaded.");
				}
				System.out.println("Enter the type of other container you want to unload or type 'Exit' to stop unloading container.");
				type = z.next();
			}else if(type.equals("Heavy")) {
				System.out.println("Enter no. container you want to unload: ");
				int cth = z.nextInt();
				sh.unloadHC(cth, hcont, ship, index, port);
				if(ship.get(index).heavyContainers == (ship.get(index).heavyContainers - cth)) {
					System.out.println(cth + " containers successfully unloaded.");
				}
				System.out.println("Enter the type of other container you want to unload or type 'Exit' to stop unloading container.");
				type = z.next();
			}else if(type.equals("Liquid")) {
				System.out.println("Enter no. container you want to unload: ");
				int ctl = z.nextInt();
				sh.unloadLC(ctl, lcont, ship, index, port);
				if(ship.get(index).liquidContainers == (ship.get(index).liquidContainers - ctl)) {
					System.out.println(ctl + " containers successfully unloaded.");
				}
				System.out.println("Enter the type of other container you want to unload or type 'Exit' to stop unloading container.");
				type = z.next();
			}else if(type.equals("Refridgerated")) {
				System.out.println("Enter no. container you want to unload: ");
				int ctr = z.nextInt();
				sh.unloadRC(ctr, rcont, ship, index, port);
				if(ship.get(index).refridgeratedContainers == (ship.get(index).refridgeratedContainers - ctr)) {
					System.out.println(ctr + " containers successfully unloaded.");
				}
				System.out.println("Enter the type of other container you want to unload or type 'Exit' to stop unloading container.");
				type = z.next();
			}else if(type.equals("Exit")) {
				System.out.println("Exiting Unloading of Containers:");
				fl = false;
			}else {
				if(fl == false)
					System.out.println("=======================================");
				else {
					System.out.println("Incorrect Input");
					break;
				}
					
			}
		}
		
	}
	
	public static void displayContainers() {
		System.out.println("========================================");
		System.out.println("List of Basic Containers: ");
		for(int i=0;i<bcont.size();i++) {
			System.out.println("(" + bcont.get(i).containerId + ", " + bcont.get(i).containerType + ", " + bcont.get(i).containerWeight + ", " + bcont.get(i).initialLoc + ")");
		}
		System.out.println("========================================");
		System.out.println("List of Heavy Containers: ");
		for(int i=0;i<hcont.size();i++) {
			System.out.println("(" + hcont.get(i).containerId + ", " + hcont.get(i).containerType + ", " + hcont.get(i).containerWeight + ", " + hcont.get(i).initialLoc + ")");
		}
		System.out.println("========================================");
		System.out.println("List of Liquid Containers: ");
		for(int i=0;i<lcont.size();i++) {
			System.out.println("(" + lcont.get(i).containerId + ", " + lcont.get(i).containerType + ", " + lcont.get(i).containerWeight + ", " + lcont.get(i).initialLoc + ")");
		}
		System.out.println("========================================");
		System.out.println("List of Refridgerated Containers: ");
		for(int i=0;i<rcont.size();i++) {
			System.out.println("(" + rcont.get(i).containerId + ", " + rcont.get(i).containerType + ", " + rcont.get(i).containerWeight + ", " + rcont.get(i).initialLoc + ")");
		}
		System.out.println("========================================");
	}
	
	public static void travelToAPort() throws InterruptedException {
		System.out.println("Enter the ID of Port you want to travel: ");
		int tvp = z.nextInt();
		Ships s = new Ships();
		System.out.println("We are at " + port.get(tvp-1).portName);
		System.out.println(port.get(tvp-1).portName + " Detalis");
		port.get(tvp-1).displayDetails();
		if(port.get(tvp-1).dockedShip == 0) {
			System.out.println("Press 1 to call for a ship.");
			int callForShip = z.nextInt();
			System.out.println(ship.get(tvp-1).shipName + " arrived.");
			port.get(tvp-1).dockedShip++;
		}else {
			if(ship.get(tvp-1).currentCount == 0) {
				ship.get(tvp-1).status = "Empty";
				System.out.println(ship.get(tvp-1).shipName + " is Empty. Press 1 to load containers in it or 2 to skip the process.");
				int actionForShip = z.nextInt();
				if(actionForShip == 1) {
					loadContainersToShip(tvp-1);
					if(ship.get(tvp-1).currentCount > 0 && !(ship.get(tvp-1).status.equals(ship.get(tvp-1).full)))
						{
							System.out.println("==========Loading Completed==========");
						}
					else if(ship.get(tvp-1).status.equals(ship.get(tvp-1).full))
						System.out.println("Ship is already full, please empty some space for new containers.");
				}
			}
		}
		System.out.println("=============================================");
		System.out.println("=============================================");
		port.get(tvp-1).displayDetails();
		System.out.println("Enter 1 for sailing the ship to any other location or 2 to return to main menu.");
		int sail = z.nextInt();
		System.out.println("=============================================");
		System.out.println("=============================================");
		ship.get(tvp-1).currentLocation = port.get(tvp-1).location;
		System.out.println("Available locations to sail: ");
		for(int i=0;i<port.size();i++) {
			if(port.get(i).portId == 1)
				continue;
			else {
				System.out.print(port.get(i).location + "  ");
			}
		}
		System.out.println();
		System.out.println("Enter the location you want to sail: ");
		String loca = z.next();
		int locId=0;
		for(Ports p: port) {
			if(p.location.equals(loca)) {
				locId = p.portId;
			}else
				continue;
		}
		s.sailShipTo(locId, port, ship, tvp-1);
		System.out.println("Sail Successfull");
		System.out.println("======================================");
		
	}


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Welcome");
		dShipAndPort(ship, port, bcont, hcont, lcont, rcont);
		boolean flag = true;
		int counter;
		while(flag) {
			System.out.println("===============MENU===============");
			System.out.println("1. To register a port.");
			System.out.println("2. To register a ship.");
			System.out.println("3. To display all the registered ports.");
			System.out.println("4. To display all the registered ships.");
			System.out.println("5. To register containers.");
			System.out.println("6. To load a ship");
			System.out.println("7. To display all the registered containers");
			System.out.println("8. To travel to a particular port");
			System.out.println("9. To unload a ship");
			System.out.println("10. To exit the application.");
			counter = z.nextInt();
			switch(counter) {
			case 1:
				System.out.println("=============================================");
				System.out.println("=============REGISTRATION OF PORT============");
				registerPort(port);
				System.out.println("All ports you wanted to register, registered sucessfully.");
				System.out.println("=============================================");
				System.out.println("=============================================");
				break;
			case 2:
				System.out.println("=============================================");
				System.out.println("============REGISTRATION OF SHIPS============");
				registerShip(ship);
				System.out.println("All ships you wanted to register, registered sucessfully.");
				System.out.println("=============================================");
				System.out.println("=============================================");
				break;
			case 3:
				System.out.println("=============================================");
				System.out.println("================PORT DETAILS=================");
				for(int i=0;i<port.size(); i++) {
					System.out.println("Port details of " + port.get(i).portName);
					port.get(i).displayDetails();
					System.out.println("=============================================");
				}
				System.out.println("=============================================");
				break;
			case 4:
				System.out.println("=============================================");
				System.out.println("================SHIP DETAILS=================");
				for(int i=0;i<ship.size(); i++) {
					System.out.println("Ship details of " + ship.get(i).shipName);
					ship.get(i).displayDetails();
					System.out.println("Currently Ship is at " + port.get(i).location);
					System.out.println("=============================================");
				}
				System.out.println("=============================================");
				break;
			case 5:
				System.out.println("=============================================");
				System.out.println("=========REGISTRATION OF CONTAINERS==========");
				containersRegistration();
				System.out.println("All containers you wanted to register, registered successfully.");
				System.out.println("=============================================");
				System.out.println("=============================================");
				break;
			case 6:
				System.out.println("=============================================");
				System.out.println("==========LOADING A CONTAINER ON SHIP========");
				System.out.println("Enter the id of Ship in which you want to Load the containers: ");
				int id = z.nextInt();
				loadContainersToShip(id);
				System.out.println("Loading Completed.");
				System.out.println("=============================================");
				System.out.println("=============================================");
			case 7:
				System.out.println("=============================================");
				System.out.println("=============CONTAINERS DETAILS==============");
				displayContainers();
				System.out.println("=============================================");
				System.out.println("=============================================");
				break;
			case 8:
				System.out.println("=============================================");
				System.out.println("============TRAVELLING TO A PORT=============");
				travelToAPort();
				System.out.println("Ship has arrived to new location, kindly unload It.");
				System.out.println("=============================================");
				System.out.println("=============================================");
				break;
			case 9:
				System.out.println("=============================================");
				System.out.println("=============UNLOADING OF A SHIP=============");
				System.out.println("Enter the id of Ship, which you want to unload: ");
				int index = z.nextInt();
				System.out.println(ship.get(index).basicContainer + " basic containers, " + ship.get(index).heavyContainers + " heavy containers, " + ship.get(index).liquidContainers + " liquid containers, " + ship.get(index).refridgeratedContainers + " refridgerated containers are present." );
				unloadConatinersFromShip(index-1);
				System.out.println("===========UNLOADING SUCCESSFULL==============");
				System.out.println("=============================================");
				break;
			case 10:
				System.out.println("EXITING");
				System.exit(0);
			default:
				System.out.println("Incorrect Input");
			}
		}
	}
}

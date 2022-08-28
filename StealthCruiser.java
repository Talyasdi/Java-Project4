package il.ac.tau.cs.sw1.ex9.starfleet;


import il.ac.tau.cs.sw1.ex9.riddles.second.A2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class StealthCruiser extends Fighter{

	private static int numOfCruisers = 0;
	private final int DOLAR_FED = 50;
	
	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		numOfCruisers++;
	}

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		this(name, commissionYear, maximalSpeed, crewMembers, Arrays.asList(new Weapon("Laser Cannons", 10, 100)));
	}
	@Override
	public int getAnnualMaintenanceCost(){
		this.annualMaintenanceCost = setAnnualMaintenanceForCruiser();
		return this.annualMaintenanceCost;
	}

	private int setAnnualMaintenanceForCruiser() {
		return  super.setAnnualMaintenance() + (DOLAR_FED*numOfCruisers) ;
	}

	@Override
	public String toString(){
		return super.toString();
	}


}

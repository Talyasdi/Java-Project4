package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public class TransportShip extends MyAbstractSpaeceship{
	private int cargoCapacity;
	private int passengerCapacity;
	private final int BASIS_FOR_TRANSPORT = 3000;
	private final int PER_TONE = 5;
	private final int PER_PASSENGER = 3;


	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		super(name, commissionYear, maximalSpeed, crewMembers);
		this.cargoCapacity = cargoCapacity;
		this.passengerCapacity = passengerCapacity;
		this.firePower = BASIS_FIRE_POWER;
		this.annualMaintenanceCost = setAnnualMaintenance();
	}

	public int getCargoCapacity(){
		return this.cargoCapacity;
	}

	public int getPassengerCapacity(){
		return this.passengerCapacity;
	}

	protected int setAnnualMaintenance(){
		return (BASIS_FOR_TRANSPORT + (PER_TONE*cargoCapacity) + (PER_PASSENGER*passengerCapacity));
	}

	@Override
	public String toString(){
		return (super.toString() + "\n" +
				"\t" + "CargoCapacity=" + getCargoCapacity() + "\n" +
				"\t" + "PassengerCapacity=" + getPassengerCapacity());
	}

}

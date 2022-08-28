package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends MyBattleship{
	private int numberOfTechnicians;
	private final int BASIS_FOR_BOMBER = 5000;

	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.numberOfTechnicians = numberOfTechnicians;
		this.annualMaintenanceCost = setAnnualMaintenance();
	}

	public int getNumberOfTechnicians(){
		return this.numberOfTechnicians;
	}

	protected int setAnnualMaintenance() {
		int sum = getAnnualMaintenanceForWeapons();
		double discount = 1 - (numberOfTechnicians*0.1);

		return (BASIS_FOR_BOMBER + (int)Math.round(discount*sum));
	}

	@Override
	public String toString(){
		return (super.toString() + "\n" +
				"\t" + "WeaponArray=" + getWeapon().toString() + "\n" +
				"\t" + "NumberOfTechnicians=" + getNumberOfTechnicians());
	}



}

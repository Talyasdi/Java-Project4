package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends MyBattleship {
	protected final int BASIS_FOR_FIGHTER = 2500;
	private final int COST_OF_ENGINE = 1000;

	public Fighter(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.annualMaintenanceCost = setAnnualMaintenance();
	}

	protected int setAnnualMaintenance() {
		int sum = getAnnualMaintenanceForWeapons();
		return BASIS_FOR_FIGHTER + sum + (int)(COST_OF_ENGINE*getMaximalSpeed());
	}


	@Override
	public String toString(){
		return (super.toString() + "\n" +
				"\t" + "WeaponArray=" + getWeapon().toString());
	}

}

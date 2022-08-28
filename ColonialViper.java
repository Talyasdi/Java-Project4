package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends Fighter  {
	private final int BASIS_COLONIALVIPER = 4000;
	private final int PER_CREW_MEMBER = 500;
	private final int PER_ENGINE = 500;

	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.annualMaintenanceCost = setAnnualMaintenance();
	}

	@Override
	protected int setAnnualMaintenance() {
		return   BASIS_COLONIALVIPER+ getAnnualMaintenanceForWeapons() + PER_CREW_MEMBER*(getCrewMembers().size()) + (int)(PER_ENGINE*getMaximalSpeed()) ;
	}

	@Override
	//override cause we need it to be updated
	public int getAnnualMaintenanceCost(){
		this.annualMaintenanceCost = setAnnualMaintenance();
		return this.annualMaintenanceCost;
	}
}

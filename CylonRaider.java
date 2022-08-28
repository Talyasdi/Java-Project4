package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends Fighter {
	private final int BASIS_CYLON= 3500;
	private final int PER_CREW_MEMBER = 500;
	private final int PER_ENGINE = 1200;


	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.annualMaintenanceCost = setAnnualMaintenance();
	}

	@Override
	protected int setAnnualMaintenance() {
		 return BASIS_CYLON + getAnnualMaintenanceForWeapons() + PER_CREW_MEMBER*getCrewMembers().size() + (int)(PER_ENGINE*getMaximalSpeed());
	}




}

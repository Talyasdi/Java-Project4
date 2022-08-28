package il.ac.tau.cs.sw1.ex9.starfleet;


import java.util.*;


public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		List<Spaceship> lst = new ArrayList<>();
		for (Spaceship s : fleet){
			lst.add(s);
		}
		Collections.sort(lst, new MySpaceshipComperator());
		List<String> res = new ArrayList<>();
		for (int i = 0 ; i< lst.size() ; i++){
			res.add(lst.get(i).toString());
		}
		return res;
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		Map<String, Integer> res = new HashMap<>();
		for (Spaceship s : fleet){
			String sName = s.getClass().getSimpleName();
			if (res.get(sName) == null){
				res.put(sName, 1);
			}
			else{
				res.put(sName, res.get(sName)+1);
			}
		}
		return res;
	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		int sum = 0;
		for (Spaceship s : fleet){
			sum += s.getAnnualMaintenanceCost();
		}
		return sum;

	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set<String> res = new HashSet<String>();
		for(Spaceship s :fleet){
			if (s instanceof MyBattleship){
				for ( Weapon w : ((MyBattleship) s).weapon){
					res.add(w.getName());
				}
			}
		}
		return res;
	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		int sum = 0 ;
		for (Spaceship s : fleet){
			sum += s.getCrewMembers().size();
		}
		return sum;
	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		float res = 0;
		int index = 0 ;

		for (Spaceship s : fleet){
			for (CrewMember c : s.getCrewMembers()){
				if (c instanceof Officer) {
					res += c.getAge();
					index++;
				}
			}
		}
		return  res/index;
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		Map<Officer, Spaceship> res = new HashMap<>();
		for (Spaceship s : fleet){
			List<Officer> ofList = new ArrayList<>();
			for (CrewMember c : s.getCrewMembers()){
				if (c instanceof Officer){
					ofList.add((Officer) c);
				}
			}
			if (ofList.size() > 0) {
				Collections.sort(ofList, new MyCrewMemberComperator());
				res.put(ofList.get(ofList.size()-1), s);
			}
		}

		return res;
	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		Map<OfficerRank, Integer> ranksMap = new HashMap<>();

		for (Spaceship s : fleet) {
			for (CrewMember c : s.getCrewMembers()) {
				if (c instanceof Officer) {
					if (ranksMap.get(((Officer) c).getRank()) == null) {
						ranksMap.put(((Officer) c).getRank(), 1);
					} else {
						ranksMap.put(((Officer) c).getRank(), ranksMap.get(((Officer) c).getRank()) + 1);
					}
				}
			}
		}

		List<Map.Entry<OfficerRank, Integer>> res = new ArrayList<>();
		res.addAll( ranksMap.entrySet());
		Collections.sort(res, new MyCrewMemberComperatorTwo());
		return res;
	}



}

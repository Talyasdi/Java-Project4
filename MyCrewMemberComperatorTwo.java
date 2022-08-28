package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Comparator;
import java.util.Map;

public class MyCrewMemberComperatorTwo implements Comparator<Map.Entry<OfficerRank, Integer>> {

    public int compare(Map.Entry<OfficerRank,Integer> s1, Map.Entry<OfficerRank, Integer> s2){
        int rankComp = Integer.compare(s1.getValue(), s2.getValue());
        if (rankComp == 0){
            return s1.getKey().compareTo(s2.getKey());
        }
        else {
            return rankComp;
        }
    }

    }

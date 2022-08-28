package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Comparator;

public class MySpaceshipComperator implements Comparator<Spaceship> {

    public int compare(Spaceship s1, Spaceship s2){
        int firePowerComp = Integer.compare(s2.getFirePower(), s1.getFirePower());
        if (firePowerComp == 0){
            int yearComp = Integer.compare(s2.getCommissionYear(), s1.getCommissionYear());
            if (yearComp == 0){
                return s1.getName().compareTo(s2.getName());
            }
            else {
                return yearComp;
            }
        }
        else {
            return firePowerComp;
        }
    }
}

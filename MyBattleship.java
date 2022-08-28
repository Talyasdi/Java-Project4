package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class MyBattleship extends MyAbstractSpaeceship{
    protected List<Weapon> weapon;


    public MyBattleship (String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons) {
        super(name, commissionYear, maximalSpeed, crewMembers);
        this.weapon = weapons;
        this.firePower = setFirePower();
    }

    public List<Weapon> getWeapon(){
        return this.weapon;
    }

    public int setFirePower (){
        int sum = 0;
        for (Weapon w : weapon){
            sum += w.getFirePower();
        }
        return BASIS_FIRE_POWER+sum;
    }

    protected int getAnnualMaintenanceForWeapons(){
        int sum = 0;
        for (Weapon w : weapon){
            sum += w.getAnnualMaintenanceCost();
        }
        return sum;
    }

    public String toString(){
        return super.toString();
    }



}

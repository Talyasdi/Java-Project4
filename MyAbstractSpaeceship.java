package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Objects;
import java.util.Set;

public abstract class MyAbstractSpaeceship implements Spaceship {
    private String name;
    private int commissionYear;
    private float maximalSpeed;
    private Set<? extends CrewMember> crewMembers;
    protected int annualMaintenanceCost;
    protected int firePower;
    protected final static int BASIS_FIRE_POWER = 10;

    public MyAbstractSpaeceship(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers){
        this.name = name;
        this.commissionYear = commissionYear;
        this.maximalSpeed = maximalSpeed;
        this.crewMembers = crewMembers;
    }

    public String getName(){
        return this.name;
    }

    public int getCommissionYear(){
        return this.commissionYear;
    }

    public float getMaximalSpeed(){
        return this.maximalSpeed;
    }

    public int getFirePower(){
        return this.firePower;
    }

    public Set<? extends CrewMember> getCrewMembers(){
        return this.crewMembers;
    }

    public int getAnnualMaintenanceCost(){
        return this.annualMaintenanceCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyAbstractSpaeceship that = (MyAbstractSpaeceship) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }


    @Override
    public String toString(){
        return (this.getClass().getSimpleName() + "\n"+
                "\t" + "Name=" + getName() + "\n" +
                "\t" + "CommissionYear=" + getCommissionYear() + "\n" +
                "\t" + "MaximalSpeed=" + getMaximalSpeed() + "\n" +
                "\t" + "FirePower=" + getFirePower() + "\n" +
                "\t" + "CrewMembers=" + getCrewMembers().size() + "\n" +
                "\t" + "AnnualMaintenanceCost=" + getAnnualMaintenanceCost());
    }

}

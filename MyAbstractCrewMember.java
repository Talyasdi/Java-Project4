package il.ac.tau.cs.sw1.ex9.starfleet;


import java.util.Objects;

public abstract class MyAbstractCrewMember implements CrewMember{
    private String name;
    private int age;
    private int yearsInService;

    public MyAbstractCrewMember(String nameIn, int ageIn, int yearsIn){
        this.name = nameIn;
        this.age = ageIn;
        this.yearsInService = yearsIn;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public int getYearsInService(){
        return this.yearsInService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyAbstractCrewMember that = (MyAbstractCrewMember) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

}

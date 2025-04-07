package collections;

public class Employee implements Comparable<Employee>{
    private String firstname;
    private String lastname;
    private String badgeNumber;

    public Employee(String firstname, String lastname, String badgeNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.badgeNumber = badgeNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBadgeNumber() {
        return badgeNumber;
    }

    @Override
    public String toString(){
        return "\""+firstname + " " + lastname + "\" \"" + badgeNumber + "\"";
    }

    @Override
    public int compareTo(Employee o) {
        return this.firstname.compareTo(o.firstname);
    }
}

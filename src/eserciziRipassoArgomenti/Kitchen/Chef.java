package eserciziRipassoArgomenti.Kitchen;

public class Chef {
    //nome cognome, grado, salario, genere
    private String name;
    private String lastName;
    private Grade grade;
    private double salary = 500;
    private boolean isFemale;
    private int performanceLevel;

    public Chef(String name, String lastName, Grade grade, boolean isFemale,int performanceLevel) {
        this.name = name;
        this.lastName = lastName;
        this.grade = grade;
        this.isFemale = isFemale;

        switch(grade) {
            case CHEF_ASSISTANT -> {this.salary *= 5;}
            case CHEF -> {this.salary += 10;}
            default -> {this.salary = 0;}
        }
        if(performanceLevel > 0 && performanceLevel <= 10){
            this.performanceLevel = performanceLevel;
        }

//        switch(grade) {
//            case CHEF_ASSISTANT:
//                this.salary *= 5;
//            case CHEF:
//                this.salary *= 10;
//                break;
//            default:
//                this.salary = 0;
//        }
    }

    public int getPerformanceLevel() {
        return performanceLevel;
    }
    public Grade getGrade() {
        return grade;
    }
    public void setGrade(Grade grade) {
        this.grade = grade;
    }
    public double getSalary() {
        return salary;
    }

}

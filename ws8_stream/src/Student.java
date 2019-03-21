public class Student {
    private String firstName;
    private String lastName;
    private double grade;
    private String department;

    //constructor
    Student(String firstName, String lastName, double grade, String department){
        if(firstName != null && lastName != null){ // names cannot be null
            this.firstName = firstName;
            this.lastName = lastName;
        }
        if(grade > 0.0 && grade <= 100.0) // grades should be in this range
            this.grade = grade;

        this.department = department;
    }

    //setters and getters
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return this.firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return this.lastName;
    }

    public void setGrade(double grade){
        this.grade = grade;
    }
    public double getGrade(){
        return this.grade;
    }

    public void setDepartment(String department){
        this.department = department;
    }
    public String getDepartment(){
        return this.department;
    }

    //getter for full name method
    public String getName(){
        return this.firstName + ' ' + this.lastName;
    }

    @Override
    public String toString(){
        return String.format("%-10s%-15s%-10.2f%-15s",
                this.firstName, this.lastName, this.grade, this.department);
    }

    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null ) return false;
        if(!(o instanceof Student)) return false;
        Student student = (Student) o;
        return student.firstName.equals(firstName) && student.lastName.equals(lastName) &&
                student.grade == grade && student.department.equals(department);
    }

}

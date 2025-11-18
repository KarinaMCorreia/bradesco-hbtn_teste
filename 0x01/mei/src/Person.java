import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Person {

    private String name;
    private String surname;
    private Date birthDate;
    private boolean anotherCompanyOwner;
    private boolean pensioner;
    private boolean publicServer;
    private float salary;

    public String fullName() {
        return name + " " + surname;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float calculateYearlySalary() {
        return salary * 12;
    }

    public boolean isMEI() {
        if (birthDate == null) {
            return false;
        }

        int age = calculateAge(birthDate);
        float yearlySalary = calculateYearlySalary();

        return yearlySalary < 130000
                && age > 18
                && !anotherCompanyOwner
                && !pensioner
                && !publicServer;
    }

    private int calculateAge(Date birthDate) {
        Calendar today = Calendar.getInstance();
        Calendar birth = new GregorianCalendar();
        birth.setTime(birthDate);

        int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);

        int monthToday = today.get(Calendar.MONTH);
        int monthBirth = birth.get(Calendar.MONTH);
        int dayToday = today.get(Calendar.DAY_OF_MONTH);
        int dayBirth = birth.get(Calendar.DAY_OF_MONTH);

        if (monthToday < monthBirth || (monthToday == monthBirth && dayToday < dayBirth)) {
            age--;
        }

        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isAnotherCompanyOwner() {
        return anotherCompanyOwner;
    }

    public void setAnotherCompanyOwner(boolean anotherCompanyOwner) {
        this.anotherCompanyOwner = anotherCompanyOwner;
    }

    public boolean isPensioner() {
        return pensioner;
    }

    public void setPensioner(boolean pensioner) {
        this.pensioner = pensioner;
    }

    public boolean isPublicServer() {
        return publicServer;
    }

    public void setPublicServer(boolean publicServer) {
        this.publicServer = publicServer;
    }
}
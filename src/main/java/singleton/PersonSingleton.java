package singleton;

/**
 * @author federico on 02/05/17.
 * @email fede.larregle@gmail.com
 */
public class PersonSingleton {

    private static final PersonSingleton instance;
    private String firstName;
    private String lastName;
    private int age;

    static {
        instance = new PersonSingleton();
    }

    private PersonSingleton() {}

    public static PersonSingleton getInstance() {
        return instance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonSingleton{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}

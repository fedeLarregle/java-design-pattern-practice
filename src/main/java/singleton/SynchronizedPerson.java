package singleton;

/**
 * Singleton implementation class that uses synchronized static factory method
 * @author federico on 04/05/17.
 * @email fede.larregle@gmail.com
 */
public class SynchronizedPerson {

    private static SynchronizedPerson instance;
    private String firstName;
    private String lastName;
    private int age;

    private SynchronizedPerson() {}

    public static synchronized SynchronizedPerson getInstance() {
        if ( instance == null ) {
            instance = new SynchronizedPerson();
        }
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
}

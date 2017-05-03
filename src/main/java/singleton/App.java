package singleton;


/**
 * @author federico on 02/05/17.
 * @email fede.larregle@gmail.com
 */
public class App {
    public static void main(String... args) {
        PersonSingleton fede = PersonSingleton.getInstance();
        fede.setFirstName("Federico");
        fede.setLastName("Larregle");
        fede.setAge(25);
        System.out.println(fede);
    }
}

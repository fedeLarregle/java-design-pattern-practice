package main.java.builder;

/**
 * Created by federico on 27/03/17.
 */
public class App {

    public static void main(String... args) {

        /* The only two mandatory fields are 'dni' and 'lastName' */
        Person person = Person.builder()
                              .dni("12.123.123")
                              .lastName("Larregle")
                              .build();
        /* As we can see 'firstName' and 'age' are not mandatory fields */
        Person person2 = Person.builder()
                               .dni("12.345.678")
                               .lastName("Karenina")
                               .firstName("Anna")
                               .age(29)
                               .build();

        System.out.println(person);
        System.out.println(person2);
    }
}

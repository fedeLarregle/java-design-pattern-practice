package main.java.builder;

/**
 * Created by federico on 27/03/17.
 */
public final class Person {

    private String dni;
    private String firstName;
    private String lastName;
    private int age;

    private Person() {}
    /* We make the constructors private so we enforce the user to only use public static factory method 'builder()' */
    private Person(final PersonBuilder builder) {
        this.dni = builder.dni;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
    }

    /*
     * Our static factory method class is going to return a 'Dni' (PersonBuilder implements this interface)
     * this enforce the client to use the abstract method from 'Dni' interface like a walk through if you wish
     */
    public static Dni builder() {
        return new PersonBuilder();
    }

    @Override
    public String toString() {
        return "Person{" +
                "dni='" + dni + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    /* Our Builder inner class */
    private static class PersonBuilder implements Dni, LastName, Build{

        private String dni;
        private String firstName;
        private String lastName;
        private int age;


        @Override
        public LastName dni(String dni) {
            this.dni = dni;
            return this;
        }

        /*
         * After given the implementation for the 'dni()' method, the 'walk through' alike enforces you to give
         * an implementation for the 'lastName(String lastName)' method from the LastName interface
         */
        @Override
        public Build lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        /*
         * After given the implementation for the 'lastName(String lastName)' method all other methods aren't mandatory
         * We only need to 'terminate' the chain of operations with the 'build()' method
         * in order to create a Person object
         */
        @Override
        public Build firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        @Override
        public Build age(int age) {
            this.age = age;
            return this;
        }


        @Override
        public Person build() {
            return new Person(this);
        }
    }

    /* Mandatory */
    interface Dni {
        public abstract LastName dni(String dni);
    }
    /* Mandatory */
    interface LastName {
        public abstract Build lastName(String lastName);
    }
    /* Optional */
    interface Build {
        public abstract Build firstName(String firstName);
        public abstract Build age(int age);
        public abstract Person build();
    }

}

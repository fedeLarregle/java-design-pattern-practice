package builder;


import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by federico on 28/03/17.
 */
public class BuilderTest {


    @Test
    public void personShouldBeInstanciated() {

        Assert.assertEquals(
                Person.builder()
                      .dni("12.345.678")
                      .lastName("Karenina")
                      .build()
                      .getClass()
                      .toString(),
                "class builder.Person"
        );
    }

    @Test
    public void personDniAndLastNameShouldBeSet() {

        Person person = Person.builder()
                .dni("12.345.678")
                .lastName("Karenina")
                .build();

        Assert.assertTrue(person.getDni().equals("12.345.678"));
        Assert.assertTrue(person.getLastName().equals("Karenina"));
    }
    
}

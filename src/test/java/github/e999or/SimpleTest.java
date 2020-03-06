package github.e999or;


import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class SimpleTest {
    private static final Logger LOG = LoggerFactory.getLogger(SimpleTest.class);
    private String name;
    private String surname;

    public SimpleTest(String name, String surname){
        this.name =name;
        this.surname = surname;
    }


    @BeforeEach
    void beforEach(){
        LOG.info("Before each");
    }

    @BeforeAll
    static void beforeALL(){
    LOG.info("Before all");
    }

    @AfterEach
    void afterEach(){
        LOG.info("After each");
    }

    @AfterAll
    static void afterALL(){
        LOG.info("After all");
    }

    @Parameterized.Parameters(name ="{index}: Имя: {0} Фамилия: {1}")
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][]{
                {"Вася", "Васильев"},
                {"Пётр", "Петров"},
        });
    }

    @Test
    public void paramTest (){
        LOG.info(name + " " +  surname);
    }
}

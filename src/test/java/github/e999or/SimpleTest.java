package github.e999or;



import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collection;

public class SimpleTest {
    private static final Logger LOG = LoggerFactory.getLogger(SimpleTest.class);

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
    @Test
    void simTest() {
        LOG.info("simple test");
    }


    public static Collection<Object[]> dataForTest() {
        return Arrays.asList(new Object[][]{
                {"Вася", "Васильев"},
                {"Пётр", "Петров"},
        });
    }

    @ParameterizedTest
    @MethodSource("dataForTest")
    public void paramTest (String name, String surname){
        LOG.info(name + " " +  surname);
    }


}

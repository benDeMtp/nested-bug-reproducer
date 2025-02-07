package org.acme;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.main.LaunchResult;
import io.quarkus.test.junit.main.QuarkusMainLauncher;
import io.quarkus.test.junit.main.QuarkusMainTest;

@QuarkusMainTest
public class GreetingCommandTest {

    @Test
    void test1(){
        assertTrue(true);
    }

    @Nested
    class Nested1{

        @Test
        void test2(){
            assertTrue(true);
        }
    }

    @Nested
    class Nested2{

        @Test
        void test3(QuarkusMainLauncher launcher){
            LaunchResult result = launcher.launch("-h");
            assertTrue(true);
        }
    }

}

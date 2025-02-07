package org.example.exercise2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Pattern;

public class PingPongTest {
    private static final Pattern PING_PATTERN = Pattern.compile("ping");
    private static final Pattern PONG_PATTERN = Pattern.compile("\t\tpong");

    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testPingPongOrder() throws InterruptedException {
        PingPong pingPong = new PingPong();
        pingPong.startPingPong();
        Thread.sleep(5000);
        pingPong.stopPingPong();

        String[] lines = outputStream.toString().split(System.lineSeparator());
        boolean pingTurn = true;

        for (String line : lines) {
            if (pingTurn) {
                assertTrue(PING_PATTERN.matcher(line).matches(), "Expected ping but got: " + line);
            } else {
                assertTrue(PONG_PATTERN.matcher(line).matches(), "Expected pong but got: " + line);
            }
            pingTurn = !pingTurn;
        }
    }

    @Test
    public void testThreadsInterrupt() throws InterruptedException {
        PingPong pingPong = new PingPong();
        pingPong.startPingPong();
        Thread.sleep(5000);
        pingPong.stopPingPong();

        for (Thread thread : pingPong.threads) {
            assertFalse(thread.isAlive(), "Thread should be terminated");
        }
    }

}

package org.example.exercise2;

public class Main {

    public static void main(String[] args) {
        PingPong pingPong = new PingPong();
        pingPong.startPingPong();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pingPong.stopPingPong();

    }

}
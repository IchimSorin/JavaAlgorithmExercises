//    2 threads ping-pong. One thread prints 'ping', another one prints' pong'. Stop after 5 seconds
//    Expected output is alternating ping-pong :
//    ping
//            pong
//    ping
//            pong
//    ping
//            pong

package org.example.exercise2;

public class PingPong {
    Thread[] threads;
    private static final Object lock = new Object();
    private static boolean pingTurn = true;

    public void startPingPong() {
        Thread pingThread = new Thread(createPingTask());
        Thread pongThread = new Thread(createPongTask());

        pingThread.start();
        pongThread.start();

        threads = new Thread[]{pingThread, pongThread};
    }

    public void stopPingPong() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Runnable createPingTask() {
        return () -> {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (lock) {
                    if (pingTurn) {
                        System.out.println("ping");
                        pingTurn = false;
                        lock.notifyAll();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                }
            }
        };
    }

    private Runnable createPongTask() {
        return () -> {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (lock) {
                    if (!pingTurn) {
                        System.out.println("\t\tpong");
                        pingTurn = true;
                        lock.notifyAll();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                }
            }
        };
    }

}

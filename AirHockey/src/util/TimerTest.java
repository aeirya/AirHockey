package util;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("PRINTLN");
            }
        },3000);

        timer.cancel();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("PRINTLN");
            }
        },3000);

    }
}

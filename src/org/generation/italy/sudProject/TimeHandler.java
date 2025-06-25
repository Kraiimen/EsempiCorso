package org.generation.italy.sudProject;

public class TimeHandler {
    public static int time;
    public static int day;
    public static TimePhase timePhase;
    public static final int ETERNAL_NIGHT = 30;

    public TimeHandler(){
        time = 0;
        day = 30;
        timePhase = TimePhase.DAY;
    }

    public static void increaseTime(int amount){
        time += amount;
        if(time >= 1000){
            time = 0;
            day++;
            if(day < ETERNAL_NIGHT){
                timePhase = TimePhase.DAY;
            }
        }
        if(time >= 500){
            timePhase = TimePhase.NIGHT;
        }
    }

    public void showTime(){
        System.out.println("\nTempo:");
        System.out.printf(
                "%-30s: %d%n" +
                "%-30s: %d%n" +
                "%-30s: %s%n%n",
                "time", time,
                "day", day,
                "time phase", timePhase.getValue()
        );
    }
}

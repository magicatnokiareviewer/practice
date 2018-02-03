package com.sdabyd2.programowanie;

public class TimeToRemember {

    private int houres;
    private int minutes;

    public TimeToRemember(int houres, int minutes) {
        this.houres = houres;
        this.minutes = minutes;
    }

    public TimeToRemember(String time) {

        String temp = time.replace("min", "").replace(" ", "");
        String[] hourMin = temp.split("h");
        int hour = Integer.parseInt(hourMin[0]);
        int mins = Integer.parseInt(hourMin[1]);

        TimeToRemember timeToRemember = new TimeToRemember(hour, mins);
        this.houres = hour;
        this.minutes = mins;
    }

    @Override
    public String toString() {

        if (minutes > 60) {
            houres += minutes / 60;
            minutes = minutes % 60;
        }
        return houres + " h " + minutes + " m";

    }

    TimeToRemember add(TimeToRemember t) {

        TimeToRemember timeToRemember = new TimeToRemember(houres, minutes);
        timeToRemember.houres += t.houres;
        timeToRemember.minutes += t.minutes;

        return timeToRemember;
    }

    TimeToRemember deduct(TimeToRemember t) {

        TimeToRemember timeToRemember = new TimeToRemember(houres, minutes);
        timeToRemember.houres -= t.houres;
        timeToRemember.minutes -= t.minutes;

        return timeToRemember;
    }

    TimeToRemember multiply(int howMany) {

        TimeToRemember timeToRemember = new TimeToRemember(houres, minutes);

        int h = timeToRemember.houres * howMany;
        int m = timeToRemember.minutes * howMany;

        TimeToRemember timeToRemember1 = new TimeToRemember(h, m);

        if (timeToRemember1.minutes > 60) {
            timeToRemember1.houres += timeToRemember1.minutes / 60;
            timeToRemember1.minutes = timeToRemember1.minutes % 60;
        }
        return timeToRemember1;
    }

    static TimeToRemember sumUp(TimeToRemember[] tab, int n) {

        TimeToRemember timeToRemember = new TimeToRemember(0,0);

        int hours=0;
        int minutes=0;

        for(int i=0;i<n;i++) {

            hours += tab[i].houres;
            minutes+=tab[i].minutes;
            timeToRemember.houres =hours;
            timeToRemember.minutes=minutes;
        }
        return timeToRemember;
    }
}

package ua.opnu;


public class TimeSpan {

    int hours;
    int minutes;

    TimeSpan(int hours, int minutes) {
        if (hours >= 0 && minutes >= 0 && minutes <= 59) {
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    int getHours() {
        return this.hours;
    }

    int getMinutes() {
        return this.minutes;
    }

    void add(int hours, int minutes) {
        if (hours >= 0 && minutes >= 0 && minutes <= 59) {
            this.hours += hours;
            this.minutes += minutes;
            if (this.minutes >= 60) {
                this.minutes -= 60;
                this.hours++;
            }
        }
    }

    void addTimeSpan(TimeSpan timespan) {
        this.hours += timespan.getHours();
        this.minutes += timespan.getMinutes();
        if (this.minutes >= 60) {
            this.minutes -= 60;
            this.hours++;
        }
    }

    double getTotalHours() {
        return this.hours + (double) (this.minutes) / 60;
    }

    int getTotalMinutes() {
        return this.hours * 60 + this.minutes;
    }

    void subtract(TimeSpan span) {
        int totalMinutesCurrent = this.getTotalMinutes();
        int totalMinutesSubtract = span.getTotalMinutes();

        if (totalMinutesSubtract > totalMinutesCurrent) {
            throw new IllegalArgumentException("Cannot subtract a larger timespan from a smaller one");
        }

        int resultMinutes = totalMinutesCurrent - totalMinutesSubtract;
        this.hours = resultMinutes / 60;
        this.minutes = resultMinutes % 60;
    }

    void scale(int factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Scale factor must be greater than zero");
        }

        int totalMinutes = this.getTotalMinutes() * factor;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }
}
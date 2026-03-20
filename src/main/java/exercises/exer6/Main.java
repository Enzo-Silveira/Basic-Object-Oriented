package exercises.exer6;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args){
        LocalTime start = LocalTime.of(8,0);
        LocalTime end = LocalTime.of(12,0);
        Meeting meeting = new Meeting("coco", start, end);

        Schedule schedule = new Schedule(LocalDate.now(),LocalTime.of(7,0),LocalTime.of(18,0));

        schedule.addMeeting(meeting);
        System.out.println(schedule.scheduleAsString());
        System.out.println(schedule.percentageSpentInMeetings());
        System.out.println(meeting.durationInMinutes());
    }
}

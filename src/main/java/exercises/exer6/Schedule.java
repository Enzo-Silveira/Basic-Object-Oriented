package exercises.exer6;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Schedule {
    private LocalDate day;
    private LocalTime startTime;
    private LocalTime endTime;

    private Meeting[] meetings = new Meeting[10];
    private int numberOfMeetings = 0;
    private long meetingTime = 0;
    private boolean flag = false;

    public Schedule(LocalDate day, LocalTime startTime, LocalTime endTime) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void addMeeting(Meeting meeting){
        if(meeting.getStartTime().isBefore(startTime) || meeting.getEndTime().isAfter(endTime)){
            System.out.println("meeting is out of work hours");
            return;
        }
        for(int i =0;i<numberOfMeetings;i++){
            if(meeting.getStartTime().isAfter(meetings[i].getStartTime()) && meeting.getEndTime().isBefore(meetings[i].getEndTime())){
                System.out.println("period already in use for other meeting");
                return;
            }
            if(meeting.getStartTime().isBefore(meetings[i].getStartTime()) && meeting.getEndTime().isAfter(meetings[i].getEndTime())){
                System.out.println("period already in use for other meeting");
                return;
            }
            if(meeting.getStartTime().isAfter(meetings[i].getStartTime()) && meeting.getStartTime().isBefore(meetings[i].getEndTime())){
                System.out.println("period already in use for other meeting");
                return;
            }
            if(meeting.getEndTime().isAfter(meetings[i].getStartTime()) && meeting.getEndTime().isBefore(meetings[i].getEndTime())){
                System.out.println("period already in use for other meeting");
                return;
            }
            if(meeting.getStartTime().equals(meetings[i].getStartTime()) || meeting.getEndTime().equals(meetings[i].getEndTime())){
                System.out.println("period already in use for other meeting");
                return;
            }
        }
        meetings[numberOfMeetings++] = meeting;
        meetingTime = meetingTime + meeting.durationInMinutes();
    }

    public void removeMeeting(Meeting meeting){
        for(int i = 0;i<numberOfMeetings-1;i++){
            if(!flag){
                if(meeting.getStartTime().equals(meetings[i].getStartTime()) && meeting.getEndTime().equals(meetings[i].getEndTime())){
                    meetingTime = meetingTime - meeting.durationInMinutes();
                    meetings[i] = meetings[i+1];
                    flag = true;
                }
            }else{
                meetings[i] = meetings[i+1];
            }
        }
        if(!flag){
            meetingTime = meetingTime - meetings[numberOfMeetings-1].durationInMinutes();
        }
        flag = false;
        numberOfMeetings--;
    }

    public double percentageSpentInMeetings(){
        long total = Duration.between(startTime, endTime).toMinutes();
        return (double) (meetingTime * 100) /total;
    }

    public String scheduleAsString(){
        StringBuilder result = new StringBuilder();
        String line;
        for(int i = 0; i< numberOfMeetings; i++){
            line = "Description: "+meetings[i].getDescription()+"\n"+"Start: "+meetings[i].getStartTime()+"\n"+"End: "+meetings[i].getEndTime()+"\n\n";
            result.append(line);
        }
        return result.toString();
    }
}

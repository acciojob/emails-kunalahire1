package com.driver;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail {

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        super(emailId, Integer.MAX_VALUE); // The inboxCapacity is equal to the maximum value an integer can store.
        this.calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting) {
        calendar.add(meeting);
    }

    public int findMaxMeetings() {
        // Sort the meetings by their end time
        Collections.sort(calendar, (m1, m2) -> m1.endTime.compareTo(m2.endTime));

        int maxMeetings = 0;
        LocalTime currentTime = LocalTime.MIN;

        for (Meeting meeting : calendar) {
            if (meeting.startTime.compareTo(currentTime) >= 0) {
                maxMeetings++;
                currentTime = meeting.endTime;
            }
        }

        return maxMeetings;
    }
}

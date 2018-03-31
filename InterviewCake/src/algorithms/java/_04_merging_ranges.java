import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// After sorting...
// At each step, either:
//
// 1- We can merge the current meeting with the previous one,
// so we do.
// 2- We can't merge the current meeting with the previous one,
// so we know the previous meeting can't be merged with any future
// meetings and we throw the current meeting into mergedMeetings.

class _04_merging_ranges {
    private class Meeting {
        private int startTime;
        private int endTime;

        Meeting(int startTime, int endTime) {
            // Number of 30 min blocks past 9:00 am
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }
    }

    public List<Meeting> mergeRanges(List<Meeting> meetings) {
        // Make a copy so we don't destroy the input
        List<Meeting> sortedMeetings = new ArrayList<>();
        for (Meeting meeting : meetings) {
            Meeting meetingCopy = new Meeting(meeting.getStartTime(), meeting.getEndTime());
            sortedMeetings.add(meetingCopy);
        }

        // Sort by start time
        sortedMeetings.sort(Comparator.comparingInt(Meeting::getStartTime));

        // Initialize mergedMeetings with the earliest meeting
        List<Meeting> mergedMeetings = new ArrayList<>();
        mergedMeetings.add(sortedMeetings.get(0));

        for (Meeting currentMeeting : sortedMeetings) {
            Meeting lastMergedMeeting = mergedMeetings.get(mergedMeetings.size() - 1);

            // If the current meeting overlaps with the last merged meeting,
            // use the later end time of the two
            if (currentMeeting.getStartTime() <= lastMergedMeeting.getEndTime()) {
                int maxEndTime = Math.max(lastMergedMeeting.getEndTime(), currentMeeting.getEndTime());
                lastMergedMeeting.setEndTime(maxEndTime);
            } else {
                // Add the current meeting since it doesn't overlap
                mergedMeetings.add(currentMeeting);
            }
        }

        return mergedMeetings;
    }
}
// O(n lg n) time
// O(n) space
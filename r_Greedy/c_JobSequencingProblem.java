import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class JobSequencingProblem {
    /**
     * Input: Four Jobs with following
     * deadlines and profits
     * JobID  Deadline  Profit
     * a      4        20
     * b      1        10
     * c      1        40
     * d      1        30
     * Output: Following is maximum
     * profit sequence of jobs
     * c, a
     * <p>
     * Input:  Five Jobs with following
     * deadlines and profits
     * JobID   Deadline  Profit
     * a       2        100
     * b       1        19
     * c       2        27
     * d       1        25
     * e       3        15
     * Output: Following is maximum
     * profit sequence of jobs
     * c, a, e
     */
    void printJobScheduling(ArrayList<Job> arr, int t) {
        arr.sort((a, b) -> b.profit - a.profit);
        // Sorted --> {(a, 2, 100), (c, 2, 27), (d, 1, 25), (b, 1, 19), (e, 3, 15)}
        boolean[] result = new boolean[t];
        char[] jobs = new char[t];

        for (int i = 0; i < arr.size(); i++) {
            // when i=0, j=Math.min(2, 1)=1
            //      when j=1, result[1]=true, jobs[1]=a // break;
            // when i=1, j=Math.min(2, 1)=1
            //      when j=0, result[0]=true, jobs[0]=c // break;
            // when i=2, j=Math.min(2, 1) --> pass
            // when i=3, j=Math.min(2, 1) --> pass
            // when i=4, j=Math.min(2, 2)=2
            //      when j=2, result[2]=true, jobs[2]=e // break;
            // overall jobs = {a, a, e}
            for (int j = Math.min(t - 1, arr.get(i).deadline - 1); j >= 0; j--) {
                if (!result[j]) {
                    result[j] = true;
                    jobs[j] = arr.get(i).id;
                    break;
                }
            }
        }
        for(char jb: jobs){
            System.out.print(jb+ " " );
        }
    }

}

class Job {
    char id;
    int deadline, profit;

    Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

class Main {
    public static void main(String[] args) {
        JobSequencingProblem j = new JobSequencingProblem();
        ArrayList<Job> jobList = new ArrayList<>();
        jobList.add(new Job('a', 2, 100));
        jobList.add(new Job('b', 1, 19));
        jobList.add(new Job('c', 2, 27));
        jobList.add(new Job('d', 1, 25));
        jobList.add(new Job('e', 3, 15));

        j.printJobScheduling(jobList, 3); // 3 : total deadline
    }
}

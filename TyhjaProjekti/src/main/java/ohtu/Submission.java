package ohtu;

public class Submission {

    private String student_number;
    private boolean a1, a2, a3, a4, a5, a6, a7, a8, a9, a10,
            a11, a12, a13, a14, a15, a16, a17, a18, a19, a20,
            a21;
    private int week, hours;
    private String completedTasksString;
    
    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public int getHours() {
        return hours;
    }
    
    public int getCompletedTasksSum() {
        int sum = 0;
        completedTasksString = "";
        
        Boolean[] tasks = {a1, a2, a3, a4, a5, a6, a7, a8, a9, a10,
            a11, a12, a13, a14, a15, a16, a17, a18, a19, a20,
            a21};
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] != false) {
                sum++;
                completedTasksString += " " + (i + 1);
            }
        }       
        return sum;
    }

    @Override
    public String toString() {
        return "viikko " + week
                + ": tehtyjä tehtäviä yhteensä: " + getCompletedTasksSum()
                + ", aikaa kului " + hours 
                + " tuntia, tehdyt tehtävät:"
                + completedTasksString;
    }

}

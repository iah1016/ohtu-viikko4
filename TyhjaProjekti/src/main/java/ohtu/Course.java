package ohtu;

/**
 *
 * @author Ilja Häkkinen
 */
public class Course {

    private String name, term;
    int week1, week2, week3, week4, week5, week6;

    public int getWeekMaxPoints(int week) {
        int[] weeks = {week1, week2, week3, week4, week5, week6};
        if (week > 0 && week <= weeks.length) {
            return weeks[week - 1];
        }
        return 0;
    }
    
    public String getName() {
        return name;
    }

    public String getTerm() {
        return term;
    }
}

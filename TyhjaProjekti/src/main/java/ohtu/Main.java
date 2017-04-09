package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "012345678";
        if (args.length > 0) {
            studentNr = args[0];
        }

        int totalAssigments = 0;
        int totalHours = 0;
        Gson mapper = new Gson();

        // Submissions
        String url = "http://ohtustats2017.herokuapp.com/students/" + studentNr + "/submissions";
        String bodyText = Request.Get(url).execute().returnContent().asString();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

        // Course
        url = "https://ohtustats2017.herokuapp.com/courses/1.json";
        bodyText = Request.Get(url).execute().returnContent().asString();
        Course course = mapper.fromJson(bodyText, Course.class);

        System.out.println("Kurssi: " + course.getName() + ", kevät 2017");
        System.out.println("opiskelijanumero: " + studentNr + "\n");

        for (Submission submission : subs) {
            submission.setMaxPoints(
                    course.getWeekMaxPoints(submission.getWeek()));
            System.out.println(" " + submission);
            totalHours += submission.getHours();
            totalAssigments += submission.getCompletedTasksSum();
        }

        System.out.println("\nyhteensä: "
                + totalAssigments + " tehtävää "
                + totalHours + " tuntia");
    }
}

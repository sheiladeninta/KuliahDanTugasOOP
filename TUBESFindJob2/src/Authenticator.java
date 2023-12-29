import java.util.ArrayList;

public class Authenticator {
    private static JobSeeker loggedInJobSeeker;

    public static JobSeeker getLoggedInJobSeeker() {
        return loggedInJobSeeker;
    }

    public static boolean login(String username, String password, ArrayList<JobSeeker> jobSeekers) {
        for (JobSeeker jobSeeker : jobSeekers) {
            if (jobSeeker.getUsername().equals(username) && jobSeeker.getPassword().equals(password)) {
                loggedInJobSeeker = jobSeeker;
                return true;
            }
        }
        return false;
    }

    public static void logout() {
        loggedInJobSeeker = null;
    }

    public boolean isAuthenticated() {
        return loggedInJobSeeker != null;
    }
    
}

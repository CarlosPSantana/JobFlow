import java.util.List;

public class JobApplicationManager {
    
    public static JobApplication findByID(List<JobApplication> applications, int id){

        for (JobApplication app : applications){
            if (app.getId() == id) {

                return app;
                
            }
        }

        return null;

    }



    public void changeStatus(List<JobApplication> applications, int id, ApplicationStatus newStatus){

        for (JobApplication app : applications){

            if (app.getId() == id) {
                
                app.setStatus(newStatus);
                break;
            }
        }
    }
}

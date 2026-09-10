import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        List<JobApplication> applications = new ArrayList<>();


        JobApplication application1 = new JobApplication(0, "DXC Technology", "Programador Java", "https://example.com", "Canary Islands", 
                                             WorkModality.REMOTE, ApplicationStatus.APPLIED, LocalDate.now(), "Primera candidatura de prueba");


        JobApplication application2 = new JobApplication(2, "DXC Technology", "Programador Java", "https://example.com", "Canary Islands", 
                                             WorkModality.REMOTE, ApplicationStatus.APPLIED, LocalDate.now(), "Primera candidatura de prueba");

        applications.add(application1);
        applications.add(application2);
        
        // for (JobApplication app : applications){
            
        //     System.out.println(app);
        // }

        for (JobApplication app : applications){
            
            if (app.getId() == 0) {
                System.out.println(app.getId());
            }
        }








    }
}

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        List<JobApplication> applications = new ArrayList<>();


        JobApplication application1 = new JobApplication(0L, "DXC Technology", "developer python", "https://example.com", "Canary Islands", 
                                             WorkModality.REMOTE, ApplicationStatus.APPLIED, LocalDate.now(), "Primera candidatura de prueba");


        JobApplication application2 = new JobApplication(2L, "DXC Technology", "Programador Java", "https://example.com", "Canary Islands", 
                                             WorkModality.REMOTE, ApplicationStatus.APPLIED, LocalDate.now(), "Primera candidatura de prueba");

        applications.add(application1);
        applications.add(application2);
        
        // for (JobApplication app : applications){
            
        //     System.out.println(app);
        // }

        List<JobApplication> pruebaPosicion = JobApplicationManager.findByPosition(applications, "developer");


        System.out.println(pruebaPosicion);




    }
}

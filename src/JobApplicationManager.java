import java.util.ArrayList;
import java.util.List;

public class JobApplicationManager {
    
    public static JobApplication findById(List<JobApplication> applications, Long id){

        for (JobApplication app : applications){
            if (app.getId().equals(id)) {

                return app;
                
            }
        }

       throw new ApplicationNotFoundException("No existe ninguna candidatura con este id " + id);

    }



    public void changeStatus(List<JobApplication> applications, Long id, ApplicationStatus newStatus){

        JobApplication application = findById(applications, id);

        application.setStatus(newStatus);
    }

    public static void addApplication(List<JobApplication> applications, JobApplication application){

        validateApplication(application);
        if (existsById(applications, application.getId())){
            
                throw new IllegalArgumentException(
                    "Ya existe una candidatura con este id"
                );

        };

        applications.add(application);

    }

    public static void validateApplication(JobApplication application){

        if (application.getCompany() == null || application.getCompany().isBlank()) {
            
            throw new IllegalArgumentException(
                "La empresa debe ser obligatoria"
            );

        } else if(application.getPosition() == null || application.getPosition().isBlank()){

            throw new IllegalArgumentException(
                "La posición debe ser obligatoria"
            );

        }
    }

    public static boolean existsById(List<JobApplication> applications, Long id){

        for (JobApplication app : applications){
            if (app.getId().equals(id)) {
                return true;
            }
        }

        return false;

    }

    public List<JobApplication> findByCompany(List<JobApplication> applications, String company){

        List<JobApplication> appCompany = new ArrayList<>();

        for(JobApplication app : applications){

            if (app.getCompany().equalsIgnoreCase(company)) {
                
                appCompany.add(app);
            }
        }

        return appCompany;

    }

    public List<JobApplication> findByStatus(List<JobApplication> applications, ApplicationStatus status){

        List<JobApplication> appStatus = new ArrayList<>();

        for(JobApplication app : applications){

            if (app.getStatus() == status) {
                
                appStatus.add(app);
            }
        }

        return appStatus;

    }

    public static void deleteById (List<JobApplication> applications, Long id){

        JobApplication application = findById(applications, id);

        applications.remove(application);

    }

    public static List<JobApplication> findByPosition(List<JobApplication> applications, String position){
        
        List<JobApplication> appPositions = new ArrayList<>();

        for (JobApplication app : applications){
            if (app.getPosition().toLowerCase().contains(position)) {
                appPositions.add(app);
            }
        }

        return appPositions;
    }
}

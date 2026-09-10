import java.time.LocalDate;

public class JobApplication {
    private int id;
    private String company;
    private String position;
    private String url;
    private String location;
    private WorkModality modality;
    private ApplicationStatus status;
    private LocalDate appliedDate;
    private String notes;


    public JobApplication(int id, String company, String position, String url, String location, WorkModality modality,
            ApplicationStatus status, LocalDate appliedDate, String notes) {
        this.id = id;
        this.company = company;
        this.position = position;
        this.url = url;
        this.location = location;
        this.modality = modality;
        this.status = status;
        this.appliedDate = appliedDate;
        this.notes = notes;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getCompany() {
        return company;
    }


    public void setCompany(String company) {
        this.company = company;
    }


    public String getPosition() {
        return position;
    }


    public void setPosition(String position) {
        this.position = position;
    }


    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }


    public String getLocation() {
        return location;
    }


    public void setLocation(String location) {
        this.location = location;
    }


    public WorkModality getModality() {
        return modality;
    }


    public void setModality(WorkModality modality) {
        this.modality = modality;
    }


    public ApplicationStatus getStatus() {
        return status;
    }


    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }


    public LocalDate getAppliedDate() {
        return appliedDate;
    }


    public void setAppliedDate(LocalDate appliedDate) {
        this.appliedDate = appliedDate;
    }


    public String getNotes() {
        return notes;
    }


    public void setNotes(String notes) {
        this.notes = notes;
    }


    @Override
    public String toString() {
        return "JobApplication \n id = " + id + ", \n company = " + company + ",\n position = " + position + ",\n url = " + url
                + ",\n location = " + location + ",\n modality = " + modality + ",\n status = " + status + ",\n appliedDate = "
                + appliedDate + ",\n notes = " + notes + "\n";
    }

    
}

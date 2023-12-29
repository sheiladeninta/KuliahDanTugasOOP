import java.util.ArrayList;

public class Database {
    private ArrayList<JobSeeker> jobSeekers;
    private ArrayList<PartnershipRequest> partnershipRequests;
    private ArrayList<JobListing> jobListings;
    private ArrayList<JobApplication> jobApplication;
    private FileHelper fileHelper;

    public Database() {
        fileHelper = new FileHelper();
        jobSeekers = fileHelper.readFromDatabaseFile("job_seekers.txt");
        partnershipRequests = fileHelper.readFromDatabaseFile("partnership_requests.txt");
        jobListings = fileHelper.readFromDatabaseFile("job_listings.txt");
        jobApplication = fileHelper.readFromDatabaseFile("job_applications.txt");

        if (jobSeekers == null) {
            jobSeekers = new ArrayList<>();
        }

        if (partnershipRequests == null) {
            partnershipRequests = new ArrayList<>();
        }

        if (jobListings == null) {
            jobListings = new ArrayList<>();
        }

        if (jobApplication == null) {
            jobApplication = new ArrayList<>();
        }
    }

    public void addJobSeeker(JobSeeker jobSeeker) {
        jobSeekers.add(jobSeeker);
        saveDataToDatabaseFile("job_seekers.txt", jobSeekers);
        System.out.println("Registrasi Berhasil!");
    }
    public ArrayList<JobSeeker> getAllJobSeekers() {
        return jobSeekers;
    }

    public void addPartnershipRequest(PartnershipRequest request) {
        partnershipRequests.add(request);
        saveDataToDatabaseFile("partnership_requests.txt", partnershipRequests);
    }
    public ArrayList<PartnershipRequest> getAllPartnershipRequests() {
        return partnershipRequests;
    }

    public void addJobListing(JobListing jobListing) {
        jobListings.add(jobListing);
        saveDataToDatabaseFile("job_listings.txt", jobListings);
        System.out.println("Lowongan pekerjaan berhasil ditambahkan");
    }
    public ArrayList<JobListing> getAllJobListings() {
        return jobListings;
    }

    public ArrayList<JobListing> searchJobListings(String keyword) {
        ArrayList<JobListing> searchResults = new ArrayList<>();
        for (JobListing jobListing : jobListings) {
            if (jobListing.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                jobListing.getCompany().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(jobListing);
            }
        }
        return searchResults;
    }

    public JobListing getJobListingByCode(String jobCode) {
        for (JobListing jobListing : jobListings) {
            if (jobListing.getJobCode().equals(jobCode)) {
                return jobListing;
            }
        }
        return null;
    }

    public void submitJobApplication(JobApplication jobApplication) {
        JobSeeker applicant = jobApplication.getApplicant();
        JobListing selectedJob = jobApplication.getSelectedJob();
        if (applicant != null && selectedJob != null) {
            jobApplication.setStatus("Submitted");
            saveDataToDatabaseFile("job_applications.txt", jobApplication);
            System.out.println("Lamaran Anda untuk " + selectedJob.getTitle() + " telah diajukan!");
        } else {
            System.out.println("Gagal mengajukan lamaran. Pastikan Anda memilih loker yang valid.");
        }
    }
    public ArrayList<JobApplication> getJobApplication() {
        return jobApplication;
    }
    
    public void saveDataToDatabaseFile(String fileName, Object data) {
        if (data instanceof ArrayList<?>) {
            fileHelper.saveToDatabaseFile(fileName, (ArrayList<?>) data);
        } else {
            ArrayList<Object> list = new ArrayList<>();
            list.add(data);
            fileHelper.saveToDatabaseFile(fileName, list);
        }
    }
    

}

package uk.ac.cf.group5.Client.Project.Submissions;

import org.springframework.stereotype.Service;

@Service
public class SubmissionServiceImpl implements SubmissionService{

    private SubmissionRepo Repo;

    public SubmissionServiceImpl (SubmissionRepo Repository){
        this.Repo = Repository;
    }


    public void add(Long contactID, Long reviewID, Long userID) {
        Repo.add(contactID,reviewID,userID);
    }

     public SubmissionItem getSubmissionItem(Long id){
        return Repo.getSubmissionItem(id);
     }

    public SubmissionItem getSubmission(Long submissionId){
        return Repo.getSubmission(submissionId);
    }
}

package uk.ac.cf.group5.Client.Project.Submissions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionServiceImpl implements SubmissionService{

    private SubmissionRepo Repo;

    public SubmissionServiceImpl (SubmissionRepo Repository){
        this.Repo = Repository;
    }


    public void add(Long contactID, Long reviewID, Long userID) {
        Repo.add(contactID,reviewID,userID);
    }


    @Override
    public List<SubmissionItem> getsubmissionItems(Long reviewID) {
        return Repo.getsubmissionItems(reviewID);
    }

    public SubmissionItem getSubmission(Long submissionId){
        return Repo.getSubmission(submissionId);
    }

    public SubmissionItem DeleteSubmissionItem(Long contactID){
        return Repo.DeleteSubmissionItem(contactID);
    }

    public SubmissionItem getSubmissionbyCon(Long id){
        return Repo.getSubmissionbyCon(id);
    }

}

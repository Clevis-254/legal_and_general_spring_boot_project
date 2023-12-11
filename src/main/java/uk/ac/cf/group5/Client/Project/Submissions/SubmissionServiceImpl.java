package uk.ac.cf.group5.Client.Project.Submissions;

import org.springframework.stereotype.Service;
import uk.ac.cf.group5.Client.Project.Answer.AnswerItem;

@Service
public class SubmissionServiceImpl implements SubmissionService{

    private SubmissionRepo Repo;

    public SubmissionServiceImpl (SubmissionRepo Repository){
        this.Repo = Repository;
    }


    public void add(submissionItem submission) {
        Repo.add(submission);
    }

     public submissionItem getSubmissionItem(Long id){
        return Repo.getSubmissionItem(id);
     }
}

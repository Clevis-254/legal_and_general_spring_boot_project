package uk.ac.cf.group5.Client.Project.Submissions;

public interface SubmissionService {

    void add(Long contactID, Long reviewID, Long userID);

    SubmissionItem getSubmissionItem(Long id);

    SubmissionItem getSubmission(Long submissionId);
}

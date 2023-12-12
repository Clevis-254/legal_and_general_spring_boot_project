package uk.ac.cf.group5.Client.Project.Submissions;

public interface SubmissionRepo {

    void add(Long contactID, Long reviewID);

    SubmissionItem getSubmissionItem(Long id);

    SubmissionItem getSubmission(Long submissionId);
}

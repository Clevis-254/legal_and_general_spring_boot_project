package uk.ac.cf.group5.Client.Project.Submissions;

public interface SubmissionService {

    void add(submissionItem Item);

    submissionItem getSubmissionItem(Long id);
}

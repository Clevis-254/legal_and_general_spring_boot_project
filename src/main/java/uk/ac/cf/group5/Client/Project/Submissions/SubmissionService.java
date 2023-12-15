package uk.ac.cf.group5.Client.Project.Submissions;

import java.util.List;

public interface SubmissionService {

    void add(Long contactID, Long reviewID, Long userID);

    List<SubmissionItem> getsubmissionItems(Long reviewID);

    SubmissionItem getSubmission(Long submissionId);

    SubmissionItem DeleteSubmissionItem(Long contactID);

    SubmissionItem getSubmissionbyCon(Long id);
}

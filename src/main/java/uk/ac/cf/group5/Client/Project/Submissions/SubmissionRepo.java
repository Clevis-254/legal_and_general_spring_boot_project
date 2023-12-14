package uk.ac.cf.group5.Client.Project.Submissions;

import uk.ac.cf.group5.Client.Project.user.UserItem;

import java.util.List;

public interface SubmissionRepo {

    void add(Long contactID, Long reviewID, Long userID);

    List<SubmissionItem> getsubmissionItems(Long reviewID);

    SubmissionItem getSubmission(Long submissionId);

    SubmissionItem DeleteSubmissionItem(Long contactID);
}

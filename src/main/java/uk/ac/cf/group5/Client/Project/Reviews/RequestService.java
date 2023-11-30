package uk.ac.cf.group5.Client.Project.Reviews;

import java.util.List;

public interface RequestService {

    void add(RequestItem request);

    List<RequestItem> getRequestItems(Long userId);
}

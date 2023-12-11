package uk.ac.cf.group5.Client.Project.Reviews;


import java.util.List;

public interface RequestRepository {

    void add(RequestItem request);

    Object findAll();

    List<RequestItem> getRequestItems(Long userId);
}

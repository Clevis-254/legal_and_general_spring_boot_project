package uk.ac.cf.group5.Client.Project.Reviews;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequestService {

    void add(RequestItem request);

    List<RequestItem> getRequestItems(Long userId);
}

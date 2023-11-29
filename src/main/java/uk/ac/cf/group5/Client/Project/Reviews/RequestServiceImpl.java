package uk.ac.cf.group5.Client.Project.Reviews;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService{

    private RequestRepository requestRepository;

    public RequestServiceImpl (RequestRepository repository){
        this.requestRepository = repository;
    }


    public void add(RequestItem request) {
        requestRepository.add(request);
    }
    public List<RequestItem> getRequestItems(Long userId){
        return requestRepository.getRequestItems(userId);
    }
}

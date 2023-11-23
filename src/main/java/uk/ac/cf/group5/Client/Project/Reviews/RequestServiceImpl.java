package uk.ac.cf.group5.Client.Project.Reviews;

import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService{

    private RequestRepository requestRepository;

    public RequestServiceImpl (RequestRepository repository){
        this.requestRepository = repository;
    }


    public void add(RequestItem request) {
        requestRepository.add(request);
    }
}

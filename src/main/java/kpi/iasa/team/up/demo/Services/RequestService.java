package kpi.iasa.team.up.demo.Services;

import kpi.iasa.team.up.demo.Exepcions.UserNotFoundExcepcion;
import kpi.iasa.team.up.demo.Model.Request;
import kpi.iasa.team.up.demo.Repository.RequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {
    private final RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public List<Request> getRequests(){
        return requestRepository.findAll();
    }
    public Request saveRequest(Request newRequest){
        return requestRepository.save(newRequest);
    }
    public Request getRequestsById(Long id){
        Optional<Request> requests = requestRepository.findById(id);
        if(requests.isPresent()){
            return requests.get();
        }
        throw new UserNotFoundExcepcion();
    }

    public Request updateRequestsById(Long id, Request updatedRequest) {
        Optional<Request> requests = requestRepository.findById(id);
        if(requests.isPresent()){
            Request oldRequest = requests.get();
            updateRequests(oldRequest, updatedRequest);
            return requestRepository.save(oldRequest);
        }
        throw new UserNotFoundExcepcion();
    }

    private void updateRequests(Request oldRequest, Request updatedRequest) {
        oldRequest.setId_player(updatedRequest.getId_player());
        oldRequest.setId_of_team(updatedRequest.getId_of_team());
        oldRequest.setStatus(updatedRequest.getStatus());
    }

    public String deleteRequestsById(Long id) {
        requestRepository.deleteById(id);
        return "Request was successfully deleted!";
    }
}

package kpi.iasa.team.up.demo.Controller;

import kpi.iasa.team.up.demo.Model.Request;
import kpi.iasa.team.up.demo.Services.RequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Controller
public class RequestController {
    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }
    @GetMapping(value = "/requests")
    public ResponseEntity<List<Request>> getRequest(){
        return ResponseEntity.ok(requestService.getRequests());
    }

    @PostMapping(value = "/requests")
    public ResponseEntity<Request> postRequest(@RequestBody Request newRequest){
        return ResponseEntity.ok(requestService.saveRequest(newRequest));
    }

    @GetMapping(value = "/requests/{id}")
    public ResponseEntity<Request> getRequest(@PathVariable Long id){
        return ResponseEntity.ok(requestService.getRequestsById(id));
    }

    @PutMapping(value = "/requests/{id}")
    public ResponseEntity<Request> updateRequest(@PathVariable Long id, @Valid @RequestBody Request updatedRequest){
        return ResponseEntity.ok(requestService.updateRequestsById(id, updatedRequest));
    }

    @DeleteMapping(value = "/requests/{id}")
    public ResponseEntity<String> deleteRequest(@PathVariable Long id){
        return ResponseEntity.ok(requestService.deleteRequestsById(id));
    }
}

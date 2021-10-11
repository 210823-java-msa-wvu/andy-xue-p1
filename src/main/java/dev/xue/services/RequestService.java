package dev.xue.services;

import dev.xue.models.Request;
import dev.xue.repositories.RequestRepo;
import dev.xue.repositories.jdbc.RequestJDBC;

import java.util.List;

public class RequestService {


    RequestRepo requestRepo = new RequestJDBC();

    public Request createRequest (Request  a) {
        return requestRepo.add(a);
    }

    public Request  searchRequestById(Integer id) {
        return requestRepo.getById(id);
    }

    public List<Request > getAllRequests() {
        return requestRepo.getAll();
    }

    public void updateRequest (Request  a) {
        requestRepo.update(a);
    }

    public void deleteRequest (Integer id) {
        requestRepo.delete(id);
    }

    public List<Request> getRequestsForEmloyee(Integer id){return requestRepo.getRequestsForEmployee(id);}

    public List<Request> getPendingRequests(){return requestRepo.getPendingRequests();}
    public List<Request> getBencoRequests() { return requestRepo.getBencoRequests();}
    public List<Request> getDptRequests(Integer id){return requestRepo.getDptRequests(id);}
    public List<Request> getSupervisorRequests(Integer id) {return requestRepo.getSupervisorRequests(id);}

    public void updateBenco(Boolean status, Integer id, String rStatus) {requestRepo.updateBenco(status, id, rStatus);}

    public void updateDptHead(boolean dptApproval, int requestID, String status) { requestRepo.updateDptHead(dptApproval, requestID, status);
    }


    public void updateSupervisor(boolean supervisorApproval, int requestID, String status, String reason) { requestRepo.updateSupervisor(supervisorApproval, requestID, status, reason);
    }


    public void updateBoth(boolean supervisorApproval, boolean dptApproval, int requestID, String status, String reason) { requestRepo.updateBoth(supervisorApproval, dptApproval, requestID, status, reason);
    }
}

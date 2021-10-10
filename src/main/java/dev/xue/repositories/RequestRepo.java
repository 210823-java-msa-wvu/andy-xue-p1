package dev.xue.repositories;

import dev.xue.models.Request;


import java.util.List;

public interface RequestRepo extends CrudRepository <Request> {
    // Create
    Request add(Request t);

    // Read
    Request getById(Integer id);

    List<Request> getAll();

    // Update
    void update(Request t);

    // Delete
    void delete(Integer id);

    List<Request> getRequestsForEmployee(Integer id);

    List<Request> getPendingRequests();

    List<Request> getDptRequests(Integer id);

    List<Request> getSupervisorRequests(Integer id);

    void updateBenco(Boolean status, Integer id, String rStatus);

    void updateDptHead(boolean dptApproval, int requestID, String status);

    void updateSupervisor(boolean supervisorApproval, int requestID, String status, String reason);
}

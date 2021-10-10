package dev.xue.services;

import dev.xue.models.Reimbursement;
import dev.xue.repositories.ReimbursementRepo;
import dev.xue.repositories.jdbc.ReimbursementJDBC;

import java.util.List;

public class ReimbursementService {

    ReimbursementRepo reimbursementRepo = new ReimbursementJDBC();

    public Reimbursement createReimbursement (Reimbursement  a) {
        return reimbursementRepo.add(a);
    }

    public Reimbursement  searchReimbursementById(Integer id) {
        return reimbursementRepo.getById(id);
    }

    public List<Reimbursement > getAllReimbursements() {
        return reimbursementRepo.getAll();
    }

    public void updateReimbursement (Reimbursement  a) {
        reimbursementRepo.update(a);
    }

    public void deleteReimbursement (Integer id) {
        reimbursementRepo.delete(id);
    }

    public Reimbursement getReimbursementByName(String name) {return reimbursementRepo.getByName(name);}
    
}

package dev.xue.repositories;

import dev.xue.models.Reimbursement;

import java.util.List;

public interface ReimbursementRepo extends CrudRepository <Reimbursement> {


    // Create
    Reimbursement add(Reimbursement t);

    // Read
    Reimbursement getById(Integer id);

    List<Reimbursement> getAll();

    // Update
    void update(Reimbursement t);

    // Delete
    void delete(Integer id);

    Reimbursement getByName(String name);


}

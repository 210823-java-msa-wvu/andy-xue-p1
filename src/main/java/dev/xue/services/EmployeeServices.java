package dev.xue.services;

import dev.xue.models.Employee;
import dev.xue.models.User;
import dev.xue.repositories.EmployeeRepo;
import dev.xue.repositories.UserRepo;
import dev.xue.repositories.jdbc.EmployeeJDBC;
import dev.xue.repositories.jdbc.UserJDBC;

import java.util.List;

// Where we are going to put any business logic needed for the application to function the way we want.
// Specifically any services that need to be available to our users.
public class EmployeeServices {

    EmployeeRepo employeeRepo = new EmployeeJDBC();

    public Employee getEmployee(String username) {

        return employeeRepo.getByUsername(username);

    }
    public Employee getEmployeeByID(int id) {

        return employeeRepo.getById(id);

    }


    public void updateTuition(float curTuition, int id) {
        employeeRepo.updateTuition(curTuition, id);
    }
}

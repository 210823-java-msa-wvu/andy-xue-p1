package dev.xue.repositories;

import dev.xue.models.Employee;


import java.util.List;

public interface EmployeeRepo extends CrudRepository<Employee> {
    Employee add(Employee user);

    Employee getById(Integer id);

    Employee getByUsername(String username);

    List<Employee> getAll();

    void update(Employee user);

    void delete(Integer id);
}

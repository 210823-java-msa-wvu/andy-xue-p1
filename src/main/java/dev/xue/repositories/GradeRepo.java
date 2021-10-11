package dev.xue.repositories;

import dev.xue.models.Grade;
import dev.xue.models.Grade;

import java.util.List;

public interface GradeRepo extends CrudRepository <Grade>  {


    Grade add(Grade t);

    // Read
    Grade getById(Integer id);

    List<Grade> getAll();

    // Update
    void update(Grade t);

    // Delete
    void delete(Integer id);
}

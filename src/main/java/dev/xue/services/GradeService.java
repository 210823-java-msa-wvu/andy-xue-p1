package dev.xue.services;

import dev.xue.models.Grade;
import dev.xue.repositories.GradeRepo;
import dev.xue.repositories.GradeRepo;
import dev.xue.repositories.jdbc.GradeJDBC;
import dev.xue.repositories.jdbc.GradeJDBC;

import java.util.List;

public class GradeService {


    GradeRepo gradeRepo = new GradeJDBC();

    public Grade createGrade (Grade  a) {
        return gradeRepo.add(a);
    }

    public Grade  searchGradeById(Integer id) {
        return gradeRepo.getById(id);
    }

    public List<Grade > getAllGrades() {
        return gradeRepo.getAll();
    }

    public void updateGrade (Grade  a) {
        gradeRepo.update(a);
    }

    public void deleteGrade (Integer id) {
        gradeRepo.delete(id);
    }


}

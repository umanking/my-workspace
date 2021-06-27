package com.example.springredis.repository;

import com.example.springredis.entity.Student;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, String>, QueryByExampleExecutor<Student> {

    // QueryMethod
    List<Student> findByName(String name);

}

package com.jcaboclo.service;

import com.jcaboclo.model.Response.StudentResponse;
import com.jcaboclo.model.request.StudentRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {

    StudentResponse createStudent(StudentRequest studentRequest);
    List<StudentResponse> getStudents();
    Page<StudentResponse> getFilteredStudent(Integer page, Integer size, String orderBy, String direction);

}

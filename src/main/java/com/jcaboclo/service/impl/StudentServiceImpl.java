package com.jcaboclo.service.impl;

import com.jcaboclo.Repository.StudentRepository;
import com.jcaboclo.model.Response.StudentResponse;
import com.jcaboclo.model.entity.Student;
import com.jcaboclo.model.request.StudentRequest;
import com.jcaboclo.service.StudentService;
import com.jcaboclo.util.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentResponse createStudent(StudentRequest studentRequest) {

        Student studentToSave = studentMapper.requestToEntity(studentRequest);

        Student savedStudent = studentRepository.save(studentToSave);

        return studentMapper.entityToResponse(savedStudent);
    }

    @Override
    public List<StudentResponse> getStudents() {

        List<Student> students = studentRepository.findAll();
        return studentMapper.entityToResponseList(students);

    }

    @Override
    public Page<StudentResponse> getFilteredStudent(Integer page, Integer size, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.valueOf(direction), orderBy);
        Page<Student> foundStudents = studentRepository.findAll(pageRequest);
        return foundStudents.map(StudentResponse::fromEntity);
    }
}

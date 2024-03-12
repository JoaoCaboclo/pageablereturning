package com.jcaboclo.util;

import com.jcaboclo.model.Response.StudentResponse;
import com.jcaboclo.model.entity.Student;
import com.jcaboclo.model.request.StudentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {

    StudentResponse requestToResponse(StudentRequest studentRequest);
    Student requestToEntity(StudentRequest request);
    StudentResponse entityToResponse(Student entity);
    List<StudentResponse> entityToResponseList(List<Student> entities);
}

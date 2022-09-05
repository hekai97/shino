package com.hekai.backend.service;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.TeacherDto;
import com.hekai.backend.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TeacherService {
    ServerResponse<Page<TeacherDto>> getTeacherListPageable(Pageable pageable);

    ServerResponse<TeacherDto> getTeacherByNumber(String number);

    ServerResponse<TeacherDto> getTeacherById(Integer id);

    ServerResponse<Teacher> save(Teacher teacher);

    ServerResponse<Teacher> updateTeacher(Teacher teacher);

    ServerResponse<List<Teacher>> getTeachersByStoreId(Integer storeId);
}

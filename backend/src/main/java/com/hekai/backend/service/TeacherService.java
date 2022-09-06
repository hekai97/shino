package com.hekai.backend.service;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.TeacherDto;
import com.hekai.backend.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 教师服务
 *
 * @author 17316
 * @date 2022/09/06
 */
public interface TeacherService {
    /**
     * 得到老师可分页列表
     *
     * @param pageable 可分页
     * @return {@link ServerResponse}<{@link Page}<{@link TeacherDto}>>
     */
    ServerResponse<Page<TeacherDto>> getTeacherListPageable(Pageable pageable);

    /**
     * 得到老师数量
     *
     * @param number 数量
     * @return {@link ServerResponse}<{@link TeacherDto}>
     */
    ServerResponse<TeacherDto> getTeacherByNumber(String number);

    /**
     * 通过id获取老师
     *
     * @param id id
     * @return {@link ServerResponse}<{@link TeacherDto}>
     */
    ServerResponse<TeacherDto> getTeacherById(Integer id);

    /**
     * 保存
     *
     * @param teacher 老师
     * @return {@link ServerResponse}<{@link Teacher}>
     */
    ServerResponse<Teacher> save(Teacher teacher);

    /**
     * 更新教师
     *
     * @param teacher 老师
     * @return {@link ServerResponse}<{@link Teacher}>
     */
    ServerResponse<Teacher> updateTeacher(Teacher teacher);

    /**
     * 教师通过存储id
     *
     * @param storeId 存储id
     * @return {@link ServerResponse}<{@link List}<{@link Teacher}>>
     */
    ServerResponse<List<Teacher>> getTeachersByStoreId(Integer storeId);
}

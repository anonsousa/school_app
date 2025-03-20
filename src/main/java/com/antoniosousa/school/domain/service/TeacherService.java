package com.antoniosousa.school.domain.service;

import com.antoniosousa.school.domain.dto.teacher.TeacherRequestDTO;
import com.antoniosousa.school.domain.dto.teacher.TeacherResponseDTO;
import com.antoniosousa.school.domain.enums.EmployeeStatus;
import com.antoniosousa.school.domain.exception.teacher.TeacherNotFoundException;
import com.antoniosousa.school.domain.mapper.TeacherMapper;
import com.antoniosousa.school.domain.model.Teacher;
import com.antoniosousa.school.domain.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    public TeacherService(TeacherRepository teacherRepository, TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }


    public TeacherResponseDTO saveTeacher(TeacherRequestDTO teacherDto) {

        Teacher teacherEntity = teacherMapper.toEntity(teacherDto);
        teacherEntity.setStatus(EmployeeStatus.ACTIVE);

        teacherRepository.save(teacherEntity);

        return teacherMapper.toDTO(teacherEntity);
    }

    public TeacherResponseDTO getTeacherById(Long id) {
        Teacher teacherEntity = teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException(id));
        return teacherMapper.toDTO(teacherEntity);
    }

    public Page<TeacherResponseDTO> getAllActiveTeachers(Pageable pageable) {
        Page<Teacher> teachers = teacherRepository.findAll(pageable);
        return teachers.map(teacherMapper::toDTO);
    }

    @Transactional
    public TeacherResponseDTO updateTeacher(Long id,
                                            TeacherRequestDTO teacherDto) {

        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException(id));

        teacherMapper.updateEntityFromDto(teacherDto, teacher);

        teacherRepository.save(teacher);

        return teacherMapper.toDTO(teacher);
    }

    public void softDeleteTeacher(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException(id));

        if (teacher.getStatus() == EmployeeStatus.INACTIVE){
            return;
        }

        teacher.setStatus(EmployeeStatus.INACTIVE);
        teacherRepository.save(teacher);
    }
}

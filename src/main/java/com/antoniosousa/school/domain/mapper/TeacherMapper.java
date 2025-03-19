package com.antoniosousa.school.domain.mapper;

import com.antoniosousa.school.domain.dto.teacher.TeacherRequestDTO;
import com.antoniosousa.school.domain.dto.teacher.TeacherResponseDTO;
import com.antoniosousa.school.domain.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fullName", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Teacher toEntity(TeacherRequestDTO teacher);

    TeacherResponseDTO toDTO(Teacher teacher);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(TeacherRequestDTO teacherDto,@MappingTarget Teacher teacher);
}

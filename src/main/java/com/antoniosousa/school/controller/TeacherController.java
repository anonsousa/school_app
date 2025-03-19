package com.antoniosousa.school.controller;

import com.antoniosousa.school.domain.dto.teacher.TeacherRequestDTO;
import com.antoniosousa.school.domain.dto.teacher.TeacherResponseDTO;
import com.antoniosousa.school.domain.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<TeacherResponseDTO> saveTeacher(
            @Valid @RequestBody TeacherRequestDTO teacherRequestDTO,
            UriComponentsBuilder uriBuilder) {

        TeacherResponseDTO response = teacherService.saveTeacher(teacherRequestDTO);

        URI resourceLocation = uriBuilder
                .path("/teacher/{id}")
                .buildAndExpand(response.id())
                .toUri();

        return ResponseEntity.created(resourceLocation).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherResponseDTO> getTeacherById(
            @PathVariable Long id,
            UriComponentsBuilder uriBuilder) {

        TeacherResponseDTO response = teacherService.getTeacherById(id);

        URI resourceLocation = uriBuilder
                .path("/teacher/{id}")
                .buildAndExpand(response.id())
                .toUri();


        return ResponseEntity.ok()
                .location(resourceLocation)
                .body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TeacherResponseDTO> updateTeacher(
            @PathVariable Long id,
            @RequestBody @Valid TeacherRequestDTO teacherRequestDTO,
            UriComponentsBuilder uriBuilder) {

        TeacherResponseDTO response = teacherService.updateTeacher(id, teacherRequestDTO);

        URI resourceLocation = uriBuilder
                .path("/teacher/{id}")
                .buildAndExpand(response.id())
                .toUri();

        return ResponseEntity.ok()
                .location(resourceLocation)
                .body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
        teacherService.softDeleteTeacher(id);
        return ResponseEntity.noContent().build();
    }
}

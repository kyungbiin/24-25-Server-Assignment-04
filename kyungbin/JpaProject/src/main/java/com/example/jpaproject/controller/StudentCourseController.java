package com.example.jpaproject.controller;

import com.example.jpaproject.dto.StudentCourseDto.StudentCourseInfoResponseDto;
import com.example.jpaproject.dto.StudentCourseDto.StudentCourseListResponseDto;
import com.example.jpaproject.dto.StudentCourseDto.StudentCourseSaveRequestDto;
import com.example.jpaproject.service.StudentCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/studentcourse")
public class StudentCourseController {
    private final StudentCourseService studentCourseService;

    @PostMapping
    public ResponseEntity<StudentCourseInfoResponseDto> save(@RequestBody StudentCourseSaveRequestDto studentCourseSaveRequestDto) {
        return new ResponseEntity<>(studentCourseService.save(studentCourseSaveRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{studentcourseId}")
    public ResponseEntity<StudentCourseInfoResponseDto> findByBookId(@PathVariable(name = "studentCoursed") int studentCourseId) {
        return new ResponseEntity<>(studentCourseService.findByStudentCourseId(studentCourseId), HttpStatus.OK);
    }
    @DeleteMapping("/{studentCourseId}")
    public ResponseEntity<StudentCourseInfoResponseDto> deleteByStudentCourseId(@PathVariable(name = "studentCourseId") int studentCourseId) {
        studentCourseService.deleteByStudentCourseId(studentCourseId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}

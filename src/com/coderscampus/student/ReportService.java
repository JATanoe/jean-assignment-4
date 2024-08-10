package com.coderscampus.student;

import java.io.IOException;

import com.coderscampus.file.FileService;

public class ReportService {

	private StudentService studentService;
	private FileService fileService;

	public ReportService(StudentService studentService, FileService fileService) {
		this.studentService = studentService;
		this.fileService = fileService;
	}

	public void generate(String courseKey, String reportFilename) throws IOException {
		Student[] courseStudents = studentService.getStudentsByCourse(courseKey);
		fileService.write(courseStudents, reportFilename);
	}

}
package com.coderscampus;

import java.io.IOException;
import java.util.Arrays;

import com.coderscampus.file.FileService;
import com.coderscampus.student.ReportService;
import com.coderscampus.student.Student;
import com.coderscampus.student.StudentService;

public class Main {

	public static void main(String[] args) throws IOException {

		String[] courses = { "APMTH", "STAT", "COMPSCI" };

		FileService fs = new FileService();
		StudentService ss = new StudentService(fs);
		ReportService rs = new ReportService(ss, fs);

		for (int i = 0; i < courses.length; i++) {
			rs.generate(courses[i], "course" + (i + 1) + ".csv");
		}
	}

}

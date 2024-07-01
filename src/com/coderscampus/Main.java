package com.coderscampus;

import java.io.IOException;
import java.util.Arrays;

import com.coderscampus.file.FileService;
import com.coderscampus.student.Student;
import com.coderscampus.student.StudentService;

public class Main {

	public static void main(String[] args) throws IOException {

		// Declares the courses names variable
		String[] courses =  { "APMTH", "STAT", "COMPSCI" };

		// Parse the Master List File and get the data
		StudentService masterService = new StudentService("student-master-list.csv");
		masterService.setStudents();
		Student[] masterList = masterService.getStudents();
		
		/** Step 1: Parse the Master List File  */		
		Student[] course1 = masterService.getStudentsByCourse(masterList, courses[0]);
		Student[] course2 = masterService.getStudentsByCourse(masterList, courses[1]);
		Student[] course3 = masterService.getStudentsByCourse(masterList, courses[2]);
		
		/** Step 2: Sort the students by grade in descending order */
		Arrays.sort(course1);
		Arrays.sort(course2);
		Arrays.sort(course3);
		
		/** Step2: Separate the Master List File data into 3 separate CSV files */
		FileService writer1 = new FileService(course1, "course1.csv");
		writer1.write();
		FileService writer2 = new FileService(course2, "course2.csv");
		writer2.write();
		FileService writer3 = new FileService(course3, "course3.csv");
		writer3.write();

	}

}

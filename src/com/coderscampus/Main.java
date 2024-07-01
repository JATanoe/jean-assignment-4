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
		
		/** Step2: Separate the Master List File data into 3 separate CSV files */
		FileService writer1 = new FileService(course1, "course1.csv");
		writer1.write();
		FileService writer2 = new FileService(course2, "course2.csv");
		writer2.write();
		FileService writer3 = new FileService(course3, "course3.csv");
		writer3.write();
		
		/** Step 3: Read data and get students from each class */
		StudentService service1 = new StudentService("course1.csv");
		service1.setStudents();
		Student[] studentsList1 = service1.getStudents();
		
		StudentService service2 = new StudentService("course2.csv");
		service2.setStudents();
		Student[] studentsList2 = service2.getStudents();
		
		StudentService service3 = new StudentService("course3.csv");
		service3.setStudents();
		Student[] studentsList3 = service3.getStudents();
		
		/** Step 4: Sort the students by grade in descending order */
		Arrays.sort(studentsList1);
		Arrays.sort(studentsList2);
		Arrays.sort(studentsList3);
		
		/** Step 5: Display the lists of students by course */
		// Course1 
		System.out.println("----- " + courses[0] + " Students List -----");
		for (Student student : studentsList1) System.out.println(student.toString());
		System.out.println();
		
		// Course2 
		System.out.println("----- " + courses[1] + " students List -----");
		for (Student student : studentsList2) System.out.println(student.toString());
		System.out.println();
		
		// Course3 
		System.out.println("----- " + courses[2] + " students List -----");
		for (Student student: studentsList3) {
			System.out.println(student.toString());
		}

	}

}

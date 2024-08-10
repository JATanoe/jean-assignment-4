package com.coderscampus.student;

import java.io.IOException;
import java.util.Arrays;

import com.coderscampus.file.FileService;

public class StudentService {

	private FileService fs = null;
	private String[] data;
	private Student[] students;

	public StudentService(FileService fs) throws IOException {
		this.fs = fs;
		loadStudents();
		sortStudents();
	}

	private void loadStudents() throws IOException {
		this.data = fs.read();
		this.students = new Student[data.length];

		this.setStudents();
	}

	private void sortStudents() {
		Arrays.sort(this.students);
	}

	public Student[] getStudents() {
		return this.students;
	}

	public void setStudents() {
		int i = 0;

		for (String row : this.data) {
			String[] params = row.split(",");
			Student student = this.createStudent(params);
			this.students[i] = student;
			i++;
		}
	}

	private Student createStudent(String[] params) {
		Integer id = Integer.parseInt(params[0]);
		String name = params[1];
		String course = params[2];
		Integer grade = Integer.parseInt(params[3]);

		return new Student(id, name, course, grade);
	}

	public Student[] getStudentsByCourse(String courseKey) {
		int count = this.getStudentsCountByCourse(courseKey);
		Student[] array = new Student[count];

		int counter = 0;

		for (Student student : this.students) {
			if (student.getCourse().matches(".*" + courseKey + ".*")) {
				array[counter] = student;
				counter++;
			}
		}

		return array;
	}

	private int getStudentsCountByCourse(String courseKey) {
		int count = 0;

		for (Student student : this.students) {
			if (student.getCourse().matches(".*" + courseKey + ".*"))
				count++;
		}

		return count;
	}

}
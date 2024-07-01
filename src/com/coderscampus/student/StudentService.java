package com.coderscampus.student;

import java.io.IOException;

import com.coderscampus.file.FileService;

public class StudentService {

	private FileService fs = null;

	private String[] data;
	private Student[] students;

	public StudentService(String _filename) throws IOException {
		this.fs = new FileService(_filename);
		this.data = fs.read();
		this.students = new Student[data.length];
	}

	public Student[] getStudents() {
		return students;
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

	public Student createStudent(String[] params) {
		Integer _id = Integer.parseInt(params[0]);
		String _name = params[1];
		String _course = params[2];
		Integer _grade = Integer.parseInt(params[3]);

		return new Student(_id, _name, _course, _grade);
	}

	public Student[] getStudentsByCourse(Student[] _array, String _regex) {
		int count = this.getStudentsCountByCourse(_array, _regex);
		Student[] array = new Student[count];

		int counter = 0;

		for (Student student : _array) {
			if (student.getCourse().matches(".*" + _regex + ".*")) {
				array[counter] = student;
				counter++;
			}
		}

		return array;
	}

	public int getStudentsCountByCourse(Student[] _array, String _regex) {
		int count = 0;

		for (Student student : _array) {
			if (student.getCourse().matches(".*" + _regex + ".*")) count++;
		}

		return count;
	}

}
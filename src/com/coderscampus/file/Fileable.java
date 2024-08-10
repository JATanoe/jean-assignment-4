package com.coderscampus.file;

import java.io.IOException;

import com.coderscampus.student.Student;

public interface Fileable {

	String[] read() throws IOException;

	void write(Student[] students, String filename) throws IOException;

}
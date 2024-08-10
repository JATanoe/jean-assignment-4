package com.coderscampus.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.coderscampus.student.Student;

public class FileService implements Fileable {

	private String MASTERLISTFILEPATH = "student-master-list.csv";

	private BufferedReader reader = null;
	private BufferedWriter writer = null;

	Student[] data = null;

	public FileService() throws IOException {
		this.reader = new BufferedReader(new FileReader(MASTERLISTFILEPATH));
	}

	public FileService(Student[] data, String file) throws IOException {
		this.writer = new BufferedWriter(new FileWriter(file));
		this.data = data;
	}

	public String[] read() throws IOException {

		try {
			String[] lines = new String[110];
			String line;
			int i = 0;

			String headLine = this.reader.readLine();
			while ((line = this.reader.readLine()) != null) {
				lines[i] = line;
				i++;
			}

			String[] result = new String[i - 1];
			System.arraycopy(lines, 0, result, 0, result.length);

			return result;

		} finally {
			if (this.reader != null)
				this.reader.close();
		}

	}

	@Override
	public void write(Student[] students, String filename) throws IOException {

		try {
			this.writer = new BufferedWriter(new FileWriter(filename));
			this.writer.write("Student ID,Student Name,Course,Grade\n");
			for (Student student : students) {
				this.writer.write(student.toString());
				this.writer.newLine();
			}

		} finally {
			this.writer.close();
		}

	}

}

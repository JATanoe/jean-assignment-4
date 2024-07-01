package com.coderscampus.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.coderscampus.student.Student;

public class FileService implements Fileable {

	private BufferedReader reader = null;
	private BufferedWriter writer = null;
	
	Student[] data = null;

	public FileService(String _file) throws IOException {
		this.reader = new BufferedReader(new FileReader(_file));
	}

	public FileService(Student[] _data, String _file) throws IOException {
		this.writer = new BufferedWriter(new FileWriter(_file));
		this.data = _data;
	}

	public String[] read() throws IOException {

		try {
			String[] lines = new String[110];
			String line;
			int i = 0;

			while ((line = this.reader.readLine()) != null) {
				if (i == 0) {
					i++;
					continue;
				}

				lines[i - 1] = line;
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
	public void write() throws IOException {

		try {

			this.writer.write("Student ID,Student Name,Course,Grade\n");
			for (Student student: this.data) {
				this.writer.write(student.toString());
				this.writer.newLine();				
			}
			
		} finally {
			this.writer.close();
		}

	}

}

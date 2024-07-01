package com.coderscampus.file;

import java.io.IOException;

public interface Fileable {
	
	String[] read() throws IOException;
	
	void write() throws IOException;
	
}
package com.inpaas.http.utils;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JSON {

	private static ObjectWriter writer;
	
	public static final ObjectWriter getWriter() {
		if (writer == null) writer = new ObjectMapper().writerWithDefaultPrettyPrinter();
		return writer;
	}
	
	
	public static final String stringify(Object data) {
		try {
			return getWriter().writeValueAsString(data);
		} catch (Exception e) {			
			StringWriter sw = new StringWriter();
			sw.write(e.getMessage().concat("\n"));
			e.printStackTrace(new PrintWriter(sw));
			
			return sw.toString();
			
		}
	}
	
	public static final void stringify(Object data, PrintStream out) {
		out.println(JSON.stringify(data));
	}
}

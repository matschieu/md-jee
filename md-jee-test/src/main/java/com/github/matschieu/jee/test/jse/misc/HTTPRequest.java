package com.github.matschieu.jee.test.jse.misc;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.apache.xerces.parsers.DOMParser;
import org.xml.sax.InputSource;

public class HTTPRequest {

	public static void main(String[] args) {
		final String URL = "http://www.google.fr";

		InputStream page = null;

		try {
			URL url = new URL(URL);
			URLConnection urlConnection = url.openConnection();
			page = urlConnection.getInputStream();
		} catch (Exception e) {
			System.err.println(String.format("Unable to connect to %s (%s)", URL, e.getMessage()));
			e.printStackTrace();
		}

		if (page != null) {
	        try {
		        DOMParser parser = new DOMParser();
				parser.parse(new InputSource(new InputStreamReader(page)));

		        System.out.println(parser.getDocument().getFirstChild().getLastChild().getTextContent());
			} catch (Exception e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}

}

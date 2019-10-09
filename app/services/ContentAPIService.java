package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.inject.Singleton;

import com.fasterxml.jackson.databind.ObjectMapper;

import entities.Image;

@Singleton
public class ContentAPIService {

	private Logger logger = Logger.getLogger("play");

	// generating a random idImg
	public int randonId() {
		logger.info("get random id");
		int idImg = (int) (Math.random() * 1084);
		return idImg;

	}

	// get image with id mult 2
	public List<Image> listMult2(List<Image> allImg) {

		List<Image> mult2 = new ArrayList<>();
		mult2 = allImg.stream().filter(i -> i.getId() % 2 == 0).collect(Collectors.toList());
		System.out.println(mult2);
		return mult2;

	}

	// map the json to a list of Img
	public List<Image> mapjson(String URL) throws IOException {

		// Connect to the URL using java's native library
		URL url = new URL(URL);
		URLConnection request = url.openConnection();
		request.connect();
		InputStream in = ((InputStream) request.getContent());
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder result = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			result.append(line);
		}
		ObjectMapper mapper = new ObjectMapper();
		logger.info("Before mapping");
		List<Image> allImg = Arrays.asList(mapper.readValue(result.toString(), Image[].class));
		List<Image> mult2 = new ArrayList<>();
		logger.info("After mapping");
		// get the list of the image where id is mult 2
		mult2 = listMult2(allImg);
		return mult2;

	}
}

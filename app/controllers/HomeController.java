package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.typesafe.config.Config;

import entities.Image;
import play.cache.SyncCacheApi;
import play.libs.ws.WSClient;
import play.mvc.Controller;
import play.mvc.Result;
import services.ContentAPIService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletionStage;

/**
 * This controller contains an action to handle HTTP requests to the
 * application's home page.
 */
public class HomeController extends Controller {

	private final Config config;
	private final SyncCacheApi cache;
	private final WSClient wsClient;
	@javax.inject.Inject
	private ContentAPIService ContentAPIService;

	@Inject
	public HomeController(Config config, SyncCacheApi cache, WSClient wsClient) {
		this.config = config;
		this.cache = cache;
		this.wsClient = wsClient;
	}

	/**
	 * An action that renders an HTML page with a welcome message. The configuration
	 * in the <code>routes</code> file means that this method will be called when
	 * the application receives a <code>GET</code> request with a path of
	 * <code>/</code>.
	 */
	public Result index() {
		return ok(views.html.index.render());
	}

	/**
	 * This is where the test will be coded
	 * 
	 * @return Result
	 */
	public CompletionStage<Result> test1() {

		return this.wsClient.url(this.config.getString("randomImageUrl")).get()
				.thenApply(file -> ok(file.getBodyAsStream()).as("image/jpeg"));

	}

	public Result test() {

		int idImg = ContentAPIService.randonId();
		String url = "";

		// test if the cache isempty
		if (cache.get("firstimgUrl1") == null) {
			// add the URL of a random image to the cache
			this.cache.set("firstimgUrl1", idImg, this.config.getInt("randomImg.cache"));
		} else {
			// get the id of the image from tha cache
			idImg = (cache.get("firstimgUrl1"));
		}
		// compose the url of the new image with the id from the cache
		url = config.getString("firstimgUrl1") + idImg + "/300/300";

		// render the hello View with random id from cache
		return ok(views.html.hello.render(url));
	}

	public Result testMultiple() throws IOException {
		try {
			mapjson();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// render the hello2 View with the list of img withid mult 2
		return ok(views.html.hello2.render(mapjson()));

	}

	
	//map the json to a list of Img
	public List<Image> mapjson() throws IOException {
		String sURL = config.getString("randomImgMult.url");

		// Connect to the URL using java's native library
		URL url = new URL(sURL);
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
		List<Image> allImg = Arrays.asList(mapper.readValue(result.toString(), Image[].class));
		List<Image> mult2 = new ArrayList<>();
		// get the list of the image where id is mult 2
		mult2 = ContentAPIService.listMult2(allImg);
		return mult2;

	}

}

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
import java.util.logging.Logger;

/**
 * This controller contains an action to handle HTTP requests to the
 * application's home page.
 */
public class HomeController extends Controller {
	private Logger logger = Logger.getLogger("play");

	private final Config config;
	private final SyncCacheApi cache;
	private final WSClient wsClient;
	private boolean test = true;
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

	public CompletionStage<Result> test() {

		int idImg = ContentAPIService.randonId();
		String url = "";

		// test if the cache isempty
		if (cache.get("firstimgUrl1") == null) {
			// add the URL of a random image to the cache
			logger.info("cache isEmpty");
			this.cache.set("firstimgUrl1", idImg, this.config.getInt("randomImg.cache"));
		} else {
			logger.info("cache isNotEmpty");
			// get the id of the image from tha cache
			idImg = (cache.get("firstimgUrl1"));
		}
		// compose the url of the new image with the id from the cache
		url = config.getString("firstimgUrl1") + idImg + "/300/300";
		final String finalUrl = url;

		// render the hello View with random id from cache
		return wsClient.url(url).get().thenApply(body -> ok(views.html.image.render(finalUrl)));

	}

	public CompletionStage<Result> testMultiple() throws IOException {
		final List<Image> listOfImg = ContentAPIService.mapjson(config.getString("randomImgMult.url"));

		return wsClient.url(config.getString("randomImgMult.url")).get()
				.thenApply(body -> ok(views.html.images.render(listOfImg)));

	}

	public CompletionStage<Result> changeTest() throws IOException {

		if (test == true) {
			test = false;
			return test();
		} else {
			test = true;
			return testMultiple();
		}

	}

}

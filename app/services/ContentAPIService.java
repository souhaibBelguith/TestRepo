package services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import entities.Image;

@Singleton
public class ContentAPIService {

	// generating a random idImg
	public int randonId() {
		int idImg = (int) (Math.random() * 1084);
		return idImg;

	}

	// get image with id mult 2
	public List<Image> listMult2(List<Image> allImg) {
		List<Image> mult2 = new ArrayList<>();
		for (Image a : allImg) {
			if ((a.getId() % 2) == 0) {
				mult2.add(a);
				// System.out.println("multi2 id : " + a.getId() + "url : " +
				// a.getDownload_url());
			}
		}
		return mult2;

	}
}

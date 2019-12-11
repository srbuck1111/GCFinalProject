package co.grandcircus.GCFinalProject.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.GCFinalProject.mappojos.UserPlace;

@Controller
public class VicinityController {
	
	
	RestTemplate rt = new RestTemplate();
	
	@Autowired
	HttpSession session;

	@RequestMapping("test")
	public ModelAndView test(String placeLat, String placeLng) {
		
		String url = "https://www.googleapis.com/geolocation/v1/geolocate?considerIp=true&key=AIzaSyD9VF75FMItSrNRMrcQMqg-ZVxJCtUwjzk";
		UserPlace request = new UserPlace();
		UserPlace userPlace = rt.postForObject(url, request, UserPlace.class);
		
		double parsedLat = userPlace.getLocation().getLat();
		double parsedLng = userPlace.getLocation().getLng();
		double parsedPlaceLat = Double.parseDouble(placeLat);
		double parsedPlaceLng = Double.parseDouble(placeLng);
		
		session.setAttribute("userLat", parsedLat);
		session.setAttribute("userLng", parsedLng);
		
		if (theseAreClose(parsedLat, parsedLng, parsedPlaceLat, parsedPlaceLng)) {
			return new ModelAndView("test", "test", "is in area" + distanceBetween(parsedLat, parsedLng, parsedPlaceLat, parsedPlaceLng));
		}
		return new ModelAndView("test", "test", "is not in area" + distanceBetween(parsedLat, parsedLng, parsedPlaceLat, parsedPlaceLng));
	}
	
	private boolean theseAreClose(double lat1, double lng1, double lat2, double lng2) {
		System.out.println(distanceBetween(lat1, lng1, lat2, lng2));
		if (distanceBetween(lat1, lng1, lat2, lng2) <= .05) {
			return true;
		}
		return false;
	}
	
	private double distanceBetween(double lat1, double lng1, double lat2, double lng2) {

		double p = 0.017453292519943295; // Math.PI / 180
		double a = 0.5 - Math.cos((lat2 - lat1) * p) / 2 + Math.cos(lat1 * p) * Math.cos(lat2 * p)
				* (1 - Math.cos((lng2 - lng1) * p)) / 2;

		return 12742 * Math.asin(Math.sqrt(a)); // 2 * R; R = 6371 km
	}
}

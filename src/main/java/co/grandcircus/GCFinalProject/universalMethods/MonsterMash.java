package co.grandcircus.GCFinalProject.universalMethods;

import java.util.ArrayList;

import org.springframework.web.client.RestTemplate;

import co.grandcircus.GCFinalProject.dndpojos.Monster;
import co.grandcircus.GCFinalProject.mappojos.Place;

public class MonsterMash {

	public Monster generateMonster() {

		RestTemplate rt = new RestTemplate();

		// Going to pull monsters from the API. API pull will be curated. Not all
		// monsters will be possible.
		Integer monsterNum = 1;
		String url = "http://dnd5eapi.co/api/monsters/" + monsterNum + "/";
		System.out.println(url);
		// Monster response = rt.getForObject(url, Monster.class);

		Monster response = rt.getForObject(url, Monster.class);

		String responseTest = rt.getForObject(url, String.class);
		System.out.println(responseTest);
		return response;
	}

	/**
	 * Method generates a random easy difficulty monster
	 * 
	 * @return a random monster object of easy difficulty
	 */
	public Monster generateEasyMonster() {

		RestTemplate rt = new RestTemplate();

		// Going to pull monsters from the API. API pull will be curated. Not all
		// monsters will be possible.
		ArrayList<Integer> monList = new ArrayList();
		monList.add(203); // Skeleton url https://66.media.tumblr.com/30712624c9a9593f25c8a72e828a9d30/tumblr_mo9yxqu6Ej1qlq9poo7_1280.jpg
		monList.add(325); // Zombie url https://www.animationmagazine.net/wordpress/wp-content/uploads/substance-source2.jpg
		monList.add(177); // Imp url https://i.pinimg.com/originals/e2/15/f1/e215f1d8d2f64f5d9d5f451b6f440f64.jpg
		monList.add(150); // Goblin url https://cdn.inprnt.com/thumbs/1f/91/1f914374bb51d27e176a8fee0ff7fddb.jpg?response-cache-control=max-age=2628000

		double rando = Math.random() * monList.size();
		int rand = (int) rando;
		int monsterNum = monList.get(rand);

		String url = "http://dnd5eapi.co/api/monsters/" + monsterNum + "/";
		System.out.println(url);
		// Monster response = rt.getForObject(url, Monster.class);

		Monster response = rt.getForObject(url, Monster.class);
		if (response.getIndex()==203) {
			response.setImageUrl("https://66.media.tumblr.com/30712624c9a9593f25c8a72e828a9d30/tumblr_mo9yxqu6Ej1qlq9poo7_1280.jpg");
		} if (response.getIndex()==325) {
			response.setImageUrl("https://www.animationmagazine.net/wordpress/wp-content/uploads/substance-source2.jpg");
		} if (response.getIndex()==177) {
			response.setImageUrl("https://i.pinimg.com/originals/e2/15/f1/e215f1d8d2f64f5d9d5f451b6f440f64.jpg");
		} if (response.getIndex()==150) {
			response.setImageUrl("https://cdn.inprnt.com/thumbs/1f/91/1f914374bb51d27e176a8fee0ff7fddb.jpg?response-cache-control=max-age=2628000");
		}

		String responseTest = rt.getForObject(url, String.class);
		System.out.println(responseTest);
		return response;
	}

	/**
	 * Method generates a random medium difficulty monster
	 * 
	 * @return a random monster object of medium difficulty
	 */
	public Monster generateMediumMonster() {

		RestTemplate rt = new RestTemplate();

		ArrayList<Integer> monList = new ArrayList();
		monList.add(285); // Treant url https://i.pinimg.com/564x/81/c1/b2/81c1b295231252a1d6b0b92eb6fbff89.jpg
		monList.add(110); // Frost Giant url https://i.pinimg.com/564x/b9/d0/49/b9d0494a3876174ef259d340cf2b05fe.jpg
		monList.add(104); // Fire Elemental url https://i.pinimg.com/originals/bc/ed/e1/bcede17691f66e8b5e03536387d6714c.jpg
		monList.add(106); // Flesh Golem url https://i.pinimg.com/originals/5e/38/63/5e38632f4fef9b1620e540a1628046c8.jpg

		double rando = Math.random() * monList.size();
		int rand = (int) rando;
		int monsterNum = monList.get(rand);

		String url = "http://dnd5eapi.co/api/monsters/" + monsterNum + "/";
		System.out.println(url);
		// Monster response = rt.getForObject(url, Monster.class);

		Monster response = rt.getForObject(url, Monster.class);

		String responseTest = rt.getForObject(url, String.class);
		
		if (response.getIndex()==285) {
			response.setImageUrl("https://i.pinimg.com/564x/81/c1/b2/81c1b295231252a1d6b0b92eb6fbff89.jpg");
		} if (response.getIndex()==110){
			response.setImageUrl("https://i.pinimg.com/564x/b9/d0/49/b9d0494a3876174ef259d340cf2b05fe.jpg");
		} if (response.getIndex()==104){
			response.setImageUrl("https://i.pinimg.com/originals/bc/ed/e1/bcede17691f66e8b5e03536387d6714c.jpg");
		} if (response.getIndex()==106){
			response.setImageUrl("https://i.pinimg.com/originals/5e/38/63/5e38632f4fef9b1620e540a1628046c8.jpg");
		}
		System.out.println(responseTest);
		return response;
		
	}

	/**
	 * Method generates a max difficulty monster
	 * 
	 * @return a random high level monster
	 */
	public Monster generateHardMonster() {

		RestTemplate rt = new RestTemplate();

		ArrayList<Integer> monList = new ArrayList();
		monList.add(173); // Hydra url https://i.pinimg.com/originals/39/b0/15/39b015bded79d89f1982c61f9aeac584.png
		monList.add(184); // Kraken url https://i.pinimg.com/originals/5f/cf/83/5fcf839c65009b139b274582552c515e.jpg
		monList.add(21); // Ancient Dragon url https://i.redd.it/2teg0tlmqdr01.jpg

		double rando = Math.random() * monList.size();
		int rand = (int) rando;
		int monsterNum = monList.get(rand);

		String url = "http://dnd5eapi.co/api/monsters/" + monsterNum + "/";
		System.out.println(url);
		// Monster response = rt.getForObject(url, Monster.class);

		Monster response = rt.getForObject(url, Monster.class);
		if (response.getIndex()==173) {
			response.setImageUrl("https://i.pinimg.com/originals/39/b0/15/39b015bded79d89f1982c61f9aeac584.png");
		} if (response.getIndex()==184) {
			response.setImageUrl("https://i.pinimg.com/originals/5f/cf/83/5fcf839c65009b139b274582552c515e.jpg");
		} if (response.getIndex()==21) {
			response.setImageUrl("https://i.redd.it/2teg0tlmqdr01.jpg");
		}

		String responseTest = rt.getForObject(url, String.class);
		System.out.println(responseTest);
		return response;
	}

	/**
	 * Method generates monster depending on player level
	 * 
	 * @param Player level
	 * 
	 * @return a random monster object
	 */
	public Monster generateMonsterByLevel(int playerLevel) {
		Monster gMonster = new Monster();

		if (playerLevel >= 4 && playerLevel < 10) {

			gMonster = generateMediumMonster();
		} else if (playerLevel <= 3) {

			gMonster = generateEasyMonster();
		} else {

			gMonster = generateHardMonster();
		}

		return gMonster;
	}

}

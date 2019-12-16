package universalMethods;

import java.util.ArrayList;

import org.springframework.web.client.RestTemplate;

import co.grandcircus.GCFinalProject.dndpojos.Monster;

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
		monList.add(203); // Skeleton
		monList.add(325); // Zombie
		monList.add(177); // Imp
		monList.add(150); // Goblin

		double rando = Math.random() * monList.size();
		int rand = (int) rando;
		int monsterNum = monList.get(rand);

		String url = "http://dnd5eapi.co/api/monsters/" + monsterNum + "/";
		System.out.println(url);
		// Monster response = rt.getForObject(url, Monster.class);

		Monster response = rt.getForObject(url, Monster.class);

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
		monList.add(285); // Treant
		monList.add(110); // Frost Giant
		monList.add(104); // Fire Elemental
		monList.add(106); // Flesh Golem

		double rando = Math.random() * monList.size();
		int rand = (int) rando;
		int monsterNum = monList.get(rand);

		String url = "http://dnd5eapi.co/api/monsters/" + monsterNum + "/";
		System.out.println(url);
		// Monster response = rt.getForObject(url, Monster.class);

		Monster response = rt.getForObject(url, Monster.class);

		String responseTest = rt.getForObject(url, String.class);
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
		monList.add(173); // Hydra
		monList.add(184); // Kraken
		monList.add(21); // Ancient Dragon

		double rando = Math.random() * monList.size();
		int rand = (int) rando;
		int monsterNum = monList.get(rand);

		String url = "http://dnd5eapi.co/api/monsters/" + monsterNum + "/";
		System.out.println(url);
		// Monster response = rt.getForObject(url, Monster.class);

		Monster response = rt.getForObject(url, Monster.class);

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

		if (playerLevel >= 3 && playerLevel < 5) {

			gMonster = generateMediumMonster();
		} else if (playerLevel <= 2) {

			gMonster = generateEasyMonster();
		} else {

			gMonster = generateHardMonster();
		}

		return gMonster;
	}

}

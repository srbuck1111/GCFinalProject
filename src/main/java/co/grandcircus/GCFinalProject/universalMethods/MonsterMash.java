package co.grandcircus.GCFinalProject.universalMethods;

import java.util.ArrayList;
import java.util.List;

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
		monList.add(259); // Skeleton
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
		List<Integer> lootTable = new ArrayList<Integer>();
		if (response.getIndex()==259) {
			response.setImageUrl("https://artfiles.alphacoders.com/593/thumb-59316.jpg");
		} if (response.getIndex()==325) {
			response.setImageUrl("https://i.pinimg.com/originals/f2/ce/5d/f2ce5d196f7f5658fec067c8f1de1bbe.jpg");
		} if (response.getIndex()==177) {
			response.setImageUrl("https://vignette.wikia.nocookie.net/aetherial-mists/images/a/ab/731_max.jpg/revision/latest/scale-to-width-down/340?cb=20130908173243");
		} if (response.getIndex()==150) {
			response.setImageUrl("https://i.imgur.com/TrQZup7.png");
		}
		
		lootTable.add(22);
		lootTable.add(28);
		lootTable.add(38);
		lootTable.add(39);
		lootTable.add(129);
		lootTable.add(129);
		lootTable.add(129);
		lootTable.add(129);
		response.setLootTable(lootTable);

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
		
		List<Integer> lootTable = new ArrayList<>();
		if (response.getIndex()==285) {
			response.setImageUrl("https://i.pinimg.com/474x/b2/a6/ba/b2a6bac3b19f3b52f1133960232d635d.jpg");
		} if (response.getIndex()==110){
			response.setImageUrl("http://photos.geni.com/p7/3808/2288/53444836dc30ba37/frost_giant_large.jpg");
		} if (response.getIndex()==104){
			response.setImageUrl("https://i.pinimg.com/originals/bc/ed/e1/bcede17691f66e8b5e03536387d6714c.jpg");
		} if (response.getIndex()==106){
			response.setImageUrl("https://66.media.tumblr.com/073d38cae7628b7c9e105f7e031ac875/tumblr_p6n1oxFKm61ro0ixho1_400.jpg");
		}
		lootTable.add(3);
		lootTable.add(15);
		lootTable.add(28);
		lootTable.add(40);
		lootTable.add(42);
		lootTable.add(44);
		lootTable.add(8);
		response.setLootTable(lootTable);
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
		List<Integer> lootTable = new ArrayList<>();
		if (response.getIndex()==173) {
			response.setImageUrl("https://i.redd.it/u5edku5cc1l01.jpg");
		} if (response.getIndex()==184) {
			response.setImageUrl("https://i.pinimg.com/564x/d8/f8/89/d8f889c1e8f640460d0b518cbd1c91db.jpg");
		} if (response.getIndex()==21) {
			response.setImageUrl("https://66.media.tumblr.com/cf15ff1f6f7bf4d1634a5b681a5908d6/tumblr_on3fy2YXIl1rxvxzbo1_400.jpg");
		}
		lootTable.add(18);
		lootTable.add(22);
		lootTable.add(47);
		lootTable.add(48);
		lootTable.add(49);
		lootTable.add(19);
		response.setLootTable(lootTable);
		
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

		if (playerLevel < 4) {

			gMonster = generateEasyMonster();
		} else if (playerLevel < 12) {

			gMonster = generateMediumMonster();
		} else {

			gMonster = generateHardMonster();
		}

		return gMonster;
	}

	private List<Integer> addLootRarity(int itemId, int rarity) {
		return null;
	}
	
}

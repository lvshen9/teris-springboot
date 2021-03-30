package com.lvshen.teris.dao;


import com.lvshen.teris.dto.Player;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataTest implements Data {

	public DataTest(HashMap<String,String> param) {
	}

	@Override
	public List<Player> loadData() {
		List<Player> players=new ArrayList<Player>();
		players.add(new Player("小明", 100));
		players.add(new Player("小明", 1000));
		//players.add(new Player("小明", 2000));
		//players.add(new Player("小明", 3000));
		players.add(new Player("小明", 4000));
		return players;
	}
	@Test
	public void testLoadData() {
		List<Player> players = loadData();
		System.out.println(players);
	}

	@Override
	public void saveData(Player players) {
		System.out.println();
	}

}

package com.lvshen.teris.dao;


import cn.hutool.core.io.file.FileWriter;
import com.lvshen.teris.dto.Player;
import com.lvshen.teris.util.FileUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;

/**
 * 村服榜
 *
 * @author lvshen
 */
@Slf4j
public class DataBase implements Data {

    private static final String DATA_A_PATH = "data/dataA.properties";

    public DataBase(HashMap<String, String> param) {
        log.info("数据库开始加载.....");
    }

    @Override
    public List<Player> loadData() {
        List<Player> sortedPlayers = FileUtils.getPlayersFromFile(DATA_A_PATH);
        return sortedPlayers;
    }

    @Override
    public void saveData(Player players) {
        if (players == null) {
            return;
        }
        FileUtils.writePlayerData(players, DATA_A_PATH);
    }


}

package com.lvshen.teris.dao;


import com.google.common.collect.Lists;
import com.lvshen.teris.dto.Player;
import com.lvshen.teris.util.FileUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;

@Slf4j
public class DataDisk implements Data {

    private static final String DATA_B_PATH = "data/dataB.properties";

    public DataDisk(HashMap<String, String> param) {
        log.info("本地数据开始加载...");
    }

    @Override
    public List<Player> loadData() {
        List<Player> sortedPlayers = FileUtils.getPlayersFromFile(DATA_B_PATH);
        return sortedPlayers;
    }

    @Override
    public void saveData(Player pla) {
        //追加新纪录
        if (pla == null) {
            return;
        }
        //重新写入
        //FileUtils.writePlayerData(pla, DATA_B_PATH);
        FileUtils.writePlayerDataWithDisk(pla, DATA_B_PATH);
    }

}

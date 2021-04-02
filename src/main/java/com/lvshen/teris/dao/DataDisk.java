package com.lvshen.teris.dao;


import com.google.common.collect.Lists;
import com.lvshen.teris.dto.Player;
import com.lvshen.teris.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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
        int nowPlayerPoint = pla.getPoint();
        List<Player> playerList = this.loadData();

        if (CollectionUtils.isNotEmpty(playerList) && playerList.size() > 1 && playerList.get(playerList.size() - 1).getPoint() > nowPlayerPoint) {
            return;
        }
        List<Player> newPlayerList = playerList.stream().filter(player -> !player.getName().equals(pla.getName())).collect(Collectors.toList());
        newPlayerList.add(pla);
        //重新写入
        //FileUtils.writePlayerData(pla, DATA_B_PATH);
        FileUtils.writePlayerDataWithDisk(newPlayerList, DATA_B_PATH);
    }

}

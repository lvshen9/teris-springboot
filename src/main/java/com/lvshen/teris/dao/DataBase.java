package com.lvshen.teris.dao;


import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.lvshen.teris.dto.Player;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 村服榜
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
        //从文件中获取player的数据记录
        FileReader fileReader = new FileReader(DATA_A_PATH);
        List<String> listDataFromFile = fileReader.readLines();

        List<Player> players = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(listDataFromFile)) {
            for (String data : listDataFromFile) {
                List<String> dataList = Splitter.on("=").omitEmptyStrings().trimResults().splitToList(data);
                String name = dataList.get(0);
                int point = Integer.parseInt(dataList.get(1));
                Player player = new Player(name, point);
                players.add(player);
            }
        }
        List<Player> sortedPlayers = players.stream().sorted(Comparator.comparing(Player::getPoint).reversed()).limit(5).collect(Collectors.toList());
        return sortedPlayers;
    }

    @Override
    public void saveData(Player players) {
        if (players == null) {
            return;
        }
        String name = players.getName();
        int point = players.getPoint();
        String playerStr = name.concat("=").concat(String.valueOf(point));
        FileWriter writer = new FileWriter(DATA_A_PATH);
        writer.append(playerStr);
    }

}

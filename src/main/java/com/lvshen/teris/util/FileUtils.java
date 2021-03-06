package com.lvshen.teris.util;

import cn.hutool.core.io.file.FileAppender;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.io.ByteSink;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import com.lvshen.teris.dto.Player;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @author Lvshen
 * @version 1.0
 * @date: 2021/4/1 21:21
 * @since JDK 1.8
 */
@Slf4j
public class FileUtils {

    public static List<Player> getPlayersFromFile(String path) {
        //从文件中获取player的数据记录
        FileReader fileReader = new FileReader(path);
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
        return players.stream().sorted(Comparator.comparing(Player::getPoint).reversed()).limit(5).collect(Collectors.toList());
    }

    public static void writePlayerData(Player players, String path) {
        String name = players.getName();
        int point = players.getPoint();
        String playerStr = name.concat("=").concat(String.valueOf(point));
        FileWriter writer = new FileWriter(path);
        writer.append(playerStr);
    }

    public static void writePlayerDataWithDisk(List<Player> players, String path) {
        /*File writer = new File(CommonUtils.getFullPath(path));
        FileAppender appender = new FileAppender(writer, 16, true);
        for (Player player : players) {
            String name = player.getName();
            int point = player.getPoint();
            String playerStr = name.concat("=").concat(String.valueOf(point));
            appender.append(playerStr);
        }
        appender.flush();*/
        List<String> playerStrList = new ArrayList<>();
        FileWriter writer = new FileWriter(path);
        for (Player player : players) {
            String name = player.getName();
            int point = player.getPoint();
            String playerStr = name.concat("=").concat(String.valueOf(point));
            playerStrList.add(playerStr);
        }
        writer.writeLines(playerStrList);
    }
}

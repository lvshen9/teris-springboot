package com.lvshen.teris.dao;


import com.google.common.collect.Lists;
import com.lvshen.teris.dto.Player;
import org.apache.commons.collections4.CollectionUtils;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class DataDisk implements Data {

    private final String filePath;

    public DataDisk(HashMap<String, String> param) {
        this.filePath = param.get("path");
    }

    @Override
    public List<Player> loadData() {

        ObjectInputStream ois = null;
        List<Player> players = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(filePath));
            players = (List<Player>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return players;
    }

    @Override
    public void saveData(Player pla) {
        //取出数据
        List<Player> players = this.loadData();
        //TODO判断记录是否超过五条，如果超过5条，去掉分数低的
        if (CollectionUtils.isNotEmpty(players)) {
            players = Lists.newArrayList();
        }
        //追加新纪录
        players.add(pla);
        //重新写入
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(
                    new FileOutputStream(filePath));

            oos.writeObject(players);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}

package com.lvshen.teris.dao;


import com.lvshen.teris.dto.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBase implements Data {

    private final String dbUrl;

    private final String dbUser;

    private final String dbPwd;

    private static String LOAD_SQL = "SELECT TOP 5 user_name,point FROM user_point WHERE type_id=1 ORDER BY point DESC";

    private static String SAVE_SQL = "INSERT INTO user_point(user_name,point,type_id) VALUES(?,?,?)";


    public DataBase(HashMap<String, String> param) {
        this.dbUrl = param.get("dbUrl");
        this.dbUser = param.get("dbUser");
        this.dbPwd = param.get("dbPwd");
        try {
            Class.forName(param.get("driver"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Player> loadData() {
        //todo 修改为从文件中获取player的数据记录

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Player> players = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
            stmt = conn.prepareStatement(LOAD_SQL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                players.add(new Player(rs.getString(1), rs.getInt(2)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                    if (stmt != null) {
                        stmt.close();
                    }
                    if (rs != null) {
                        rs.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return players;
    }

    @Override
    public void saveData(Player players) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
            stmt = conn.prepareStatement(SAVE_SQL);
            stmt.setObject(1, players.getName());
            stmt.setObject(2, players.getPoint());
            stmt.setObject(3, 1);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                    if (stmt != null) {
                        stmt.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
//	public static void main(String[] args) {
//		DataBase db=new DataBase();
//		db.saveData(new Player("GM", 99999));
//		System.out.println(111);
//	}

}

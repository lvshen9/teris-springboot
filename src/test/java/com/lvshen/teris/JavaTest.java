package com.lvshen.teris;

import com.lvshen.teris.dto.Player;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author Lvshen
 * @version 1.0
 * @date: 2021/3/30 19:46
 * @since JDK 1.8
 */
public class JavaTest {
    @Test
    public void testLoadData() {

        List<Player> players = new ArrayList<Player>();
        players.add(new Player("小明", 100));
        players.add(new Player("小明", 1000));
        //players.add(new Player("小明", 2000));
        //players.add(new Player("小明", 3000));
        players.add(new Player("小明", 4000));
    }
}

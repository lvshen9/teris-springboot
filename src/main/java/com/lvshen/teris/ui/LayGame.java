package com.lvshen.teris.ui;

import java.awt.Graphics;
import java.awt.Point;

import com.lvshen.teris.config.GameConfig;
import com.lvshen.teris.entity.GameAct;

public class LayGame extends Lay {
    /**
     * 左位移偏移量
     */
    private static final int SIZE_ROL = GameConfig.getFrameConfig().getSizeRol();

    private static final int LEFT_SIDE = 0;

    private static final int RIGHT_SIDE = GameConfig.getSystemConfig().getMaxX();

    private static final int LOSE_IDX = GameConfig.getFrameConfig().getLoseIdx();

    public LayGame(int x, int y, int w, int h) {
        super(x, y, w, h);

    }

    @Override
    public void paint(Graphics g) {
        this.createWindow(g);
        //获得方块数组集合
        GameAct act = this.dto.getGameAct();
        if (act != null) {
            Point[] points = act.getActPoints();
            //绘制阴影
            this.drawShadow(points, g);
            //绘制活动方块
            this.drawMainAct(points, g);
        }
        //绘制游戏的图
        this.drawMap(g);
        if (this.dto.isPause()) {
            this.drawImageAtCenter(Img.PAUSE, g);
        }
    }

    /**
     * 绘制游戏地图
     *
     * @param g
     */
    private void drawMap(Graphics g) {
        //绘制地图
        boolean[][] map = this.dto.getGameMap();
        //计算当前堆积颜色
        int lv = this.dto.getNowLevel();
        int imgIdx = lv == 0 ? 0 : (lv - 1) % 7 + 1;
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                if (map[x][y]) {
                    this.drawActByPoint_1(x, y, imgIdx, g);
                }
            }
        }
    }

    /**
     * 绘制活动方块
     *
     * @param g
     */
    private void drawMainAct(Point[] points, Graphics g) {
        //获得方块类型编号(0-6)
        int typeCode = this.dto.getGameAct().getTypeCode();
        //绘制方块
        for (int i = 0; i < points.length; i++) {
            this.drawActByPoint(points[i].x, points[i].y, typeCode + 1, g);

        }
    }

    /**
     * 绘制阴影
     *
     * @param points
     */
    private void drawShadow(Point[] points, Graphics g) {
        //TODO p)阴影关闭
        if (!this.dto.isShowShadow()) {
            return;
        }
        int leftX = RIGHT_SIDE;
        int rightX = LEFT_SIDE;
        for (Point p : points) {
            leftX = p.x < leftX ? p.x : leftX;
            rightX = p.x > rightX ? p.x : rightX;
        }
        g.drawImage(Img.SHODOW,
                this.x + BORDER + (leftX << SIZE_ROL),
                this.y + BORDER,
                (rightX - leftX + 1) << SIZE_ROL,
                this.h - (BORDER << 1), null
        );
    }

    /**
     * 绘制正方形快
     *
     * @param x
     * @param y
     * @param g
     */
    private void drawActByPoint(int x, int y, int imgIndx, Graphics g) {
        imgIndx = this.dto.isStart() ? imgIndx : LOSE_IDX;
        g.drawImage(Img.ACT,
                this.x + (x << SIZE_ROL) + BORDER,
                this.y + (y << SIZE_ROL) + BORDER,
                this.x + (x + 1 << SIZE_ROL) + BORDER,
                this.y + (y + 1 << SIZE_ROL) + BORDER,
                imgIndx << SIZE_ROL, 0, (imgIndx + 1) << SIZE_ROL, 1 << SIZE_ROL, null);
    }

    //复写方法，绘制地图
    private void drawActByPoint_1(int x, int y, int imgIndx, Graphics g) {
        imgIndx = this.dto.isStart() ? imgIndx : LOSE_IDX;
        g.drawImage(Img.ACT_1,
                this.x + (x << SIZE_ROL) + 7,
                this.y + (y << SIZE_ROL) + 7,
                this.x + (x + 1 << SIZE_ROL) + 7,
                this.y + (y + 1 << SIZE_ROL) + 7,
                imgIndx << SIZE_ROL, 0, (imgIndx + 1) << SIZE_ROL, 1 << SIZE_ROL, null);
    }

}

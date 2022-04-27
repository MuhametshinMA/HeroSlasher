package com.example.heroslasher.objects;

import android.graphics.Color;

import com.example.gear2d.CoreFW;
import com.example.gear2d.GraphicsFW;
import com.example.heroslasher.R;

public class Header {
    public static double passedDistance;
    private double currentSpeedPlayer;
    private int currentShieldPlayer;

    CoreFW coreFW;

    private final int HEIGHT_HEADER = 50;

    public Header(CoreFW core) {
        this.coreFW = core;
    }
    /*public void update(int passedDistance, int currentSpeedPlayer, int currentShieldPlayer) {
        this.passedDistance = passedDistance;
        this.currentSpeedPlayer = currentSpeedPlayer;
        this.currentShieldPlayer = currentShieldPlayer;
    }*/
    public void drawing(GraphicsFW graphicsFW) {
        graphicsFW.drawLine(0, HEIGHT_HEADER, graphicsFW.getWidthFrameBuffer(), HEIGHT_HEADER, Color.WHITE);
        graphicsFW.drawText(coreFW.getString(R.string.txt_header_currentShield) + currentShieldPlayer,
                10, 30, Color.GREEN, 25, null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_header_currentSpeed) + currentSpeedPlayer,
                210, 30, Color.GREEN, 25, null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_header_passedDistance) + passedDistance,
                410, 30, Color.GREEN, 25, null);
    }

    public int getHEIGHT_HEADER() {
        return HEIGHT_HEADER;
    }

    public double getPassedDistance() {
        return passedDistance;
    }

    public void setPassedDistance(double passedDistance) {
        this.passedDistance += passedDistance;
    }

    public double getCurrentSpeedPlayer() {
        return currentSpeedPlayer;
    }

    public void setCurrentSpeedPlayer(double currentSpeedPlayer) {
        this.currentSpeedPlayer = currentSpeedPlayer;
    }

    public int getCurrentShieldPlayer() {
        return currentShieldPlayer;
    }

    public void setCurrentShieldPlayer(int currentShieldPlayer) {
        this.currentShieldPlayer = currentShieldPlayer;
    }
}

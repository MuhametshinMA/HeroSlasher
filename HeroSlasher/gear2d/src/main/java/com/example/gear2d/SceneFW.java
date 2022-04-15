package com.example.gear2d;

public abstract class SceneFW {
    public CoreFW coreFW;
    public int sceneWidth;
    public int sceneHeight;
    public GraphicsFW graphicsFW;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public SceneFW(CoreFW coreFW) {
        this.coreFW = coreFW;
        sceneHeight = coreFW.getGraphics().getHeightFrameBuffer();
        sceneWidth = coreFW.getGraphics().getWidthFrameBuffer();
        graphicsFW = coreFW.getGraphics();
    }
    public abstract void update();
    public abstract void drawing();
    public abstract void pause();
    public abstract void resume();
    public abstract void dispose();
}
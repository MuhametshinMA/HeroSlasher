package com.example.gear2d;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;

import java.io.IOException;
import java.io.InputStream;

public class GraphicsFW {

    private AssetManager assetManagerGame;
    private Bitmap frameBufferGame;
    private Canvas canvasGame;
    private Paint paintGame;
    private Bitmap textureGame;

    public GraphicsFW(AssetManager assetManagerGame, Bitmap frameBufferGame) {
        this.assetManagerGame = assetManagerGame;
        this.frameBufferGame = frameBufferGame;
        this.canvasGame = new Canvas(frameBufferGame);
        this.paintGame = new Paint();
    }

    public void clearScene(int colorRGB) {
        canvasGame.drawRGB(colorRGB,colorRGB,colorRGB);
    }

    public void drawPixel(int x, int y, int color) {
        paintGame.setColor(color);
        canvasGame.drawPoint(x, y, paintGame);
    }
    public void drawLine(int startX, int startY, int stopX, int stopY, int color) {
        paintGame.setColor(color);
        canvasGame.drawLine(startX, startY, stopX, stopY, paintGame);
    }

    public void drawRect(int left, int top, int right, int bottom, int color) {
        Rect rect = new Rect();
        rect.set(left, top, right, bottom);
        paintGame.setColor(color);
        paintGame.setStyle(Paint.Style.FILL);
        canvasGame.drawRect(rect, paintGame);
    }

    public void drawText(String text, int x, int y, int color, int sizeText, Typeface font) {
        paintGame.setColor(color);
        paintGame.setTextSize(sizeText);
        paintGame.setTypeface(font);
        canvasGame.drawText(text, x, y, paintGame);
    }
    public void drawTexture(Bitmap textureGame, int x, int y) {
        canvasGame.drawBitmap(textureGame, x, y, null);
    }
    public int getWidthFrameBuffer() {
        return frameBufferGame.getWidth();
    }
    public int getHeightFrameBuffer() {
        return frameBufferGame.getHeight();
    }
    public Bitmap newTexture(String fileName) {
        InputStream inputStream = null;
        try {
            inputStream = assetManagerGame.open(fileName);
            textureGame = BitmapFactory.decodeStream(inputStream);
            if (textureGame == null) {
                throw new RuntimeException("Can't upload file" + fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return textureGame;
    }
}
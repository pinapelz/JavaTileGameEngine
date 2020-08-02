/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jswinggame;

import Input.KeyManager;
import Input.MouseManager;
import display.Display;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import jswinggame.*;


/**
 *
 * @author donal
 */
public class Game implements Runnable {

    int displayfps = 0;
    int fps = 60;
    private Thread thread;
    private boolean running = false;
    private Display display;
    private MouseManager mouseManager;
    public String title;
    private int width, height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    private BufferStrategy bs;
    private Graphics g;

    private KeyManager keyManager;

    private Handler hand;

    public Game(String title, int width, int height) {
       
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();

    }

    public void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);


    }

    public KeyManager getKeyManager() {
        return keyManager;
    }



    public MouseManager getMouseManager() {
        return mouseManager;
    }

    private void update() {
        keyManager.tick();
      

    }

    private void render() {

        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);

        g.setColor(Color.YELLOW);
        g.setFont(new Font("Arial", Font.BOLD, 13));
        g.drawString("FPS: " + Integer.toString(displayfps), 0, 10);
        bs.show();
        g.dispose();

    }

    public void run() {
        init();
        long timer = 0;
        int ticks = 0;
        long timera = System.currentTimeMillis();
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();

        while (running == true) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
            if (delta >= 1) {
                update();
                render();
                ticks++;

                --delta;
            }
            if (timer >= 1000000000) {     //
                //System.out.println("FPS " + ticks);
                displayfps = ticks;
    
                ticks = 0;

                timer = 0;
          
            }

        }
        stop();
        System.exit(0);
    }

    public synchronized void start() {
        if (running == true) {
            return;
        } else {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    public synchronized void stop() {
        if (running == false) {
            return;
        } else {
            try {
                thread.join();
            } catch (InterruptedException ex) {
                System.err.println("Thread Error In Game.java!");
                JOptionPane.showMessageDialog(null, "Error in the thread");
            }
        }
    }
  
}

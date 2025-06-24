package org.generation.italy.sudProject.map;

import javax.swing.*;
import java.awt.*;

public class MapFrame extends JFrame {

    private MapPanel mapPanel;

    public MapFrame() {
        setTitle("Mappa");
        setSize(900, 800);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mapPanel = new MapPanel();
        add(mapPanel);

        setVisible(true);
    }

    public void updateMap(String mapText) {
        mapPanel.setMapText(mapText);
    }

    public void updateTime(String timeText) {
        mapPanel.setTimeText(timeText);
    }
}

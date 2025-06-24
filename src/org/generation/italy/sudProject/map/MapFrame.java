package org.generation.italy.sudProject.map;

import javax.swing.*;
import java.awt.*;

public class MapFrame extends JFrame {

    private MapPanel mapPanel;

    public MapFrame() {
        setTitle("Mappa");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mapPanel = new MapPanel();
        add(mapPanel);

        setVisible(true);
    }

    public void updateMap(String mapText) {
        mapPanel.setMapText(mapText);
    }
}

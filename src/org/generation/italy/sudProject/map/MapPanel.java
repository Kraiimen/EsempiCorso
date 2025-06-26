package org.generation.italy.sudProject.map;

import org.generation.italy.sudProject.TimeHandler;
import org.generation.italy.sudProject.TimePhase;

import javax.swing.*;
import java.awt.*;

public class MapPanel extends JPanel {

    private String mapText = "";
    private String timeText = "";
    private String entitiesText = "";

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        if(TimeHandler.timePhase == TimePhase.DAY){
            setBackground(Color.darkGray);
            g2d.setColor(new Color(255, 255, 255)); // Bianco
        } else {
            setBackground(Color.BLACK);
            g2d.setColor(new Color(255, 165, 0)); // Arancione
        }

        g2d.setFont(new Font("Monospaced", Font.PLAIN, 14));

        FontMetrics fm = g2d.getFontMetrics();

        // Disegna la mappa centrata
        String[] mapLines = mapText.split("\n");
        int lineHeight = fm.getHeight();
        int totalMapHeight = mapLines.length * lineHeight;
        int y = (getHeight() - totalMapHeight) / 2 + fm.getAscent() - 50; // sposta un po' in alto per spazio sotto

        for (String line : mapLines) {
            int lineWidth = fm.stringWidth(line);
            int x = (getWidth() - lineWidth) / 2;
            g2d.drawString(line, x, y);
            y += lineHeight;
        }

        // Disegna il tempo in alto a sinistra
        if (timeText != null && !timeText.isEmpty()) {
            String[] timeLines = timeText.split("\n");
            int timeY = 20;
            for (String line : timeLines) {
                g2d.drawString(line, 20, timeY);
                timeY += lineHeight;
            }
        }

        // Disegna le entità in basso a sinistra
        if (entitiesText != null && !entitiesText.isEmpty()) {
            String[] entityLines = entitiesText.split("\n");
            int entityY = getHeight() - (entityLines.length * lineHeight) - 20; // 20 px dal fondo
            int entityX = 20;
            for (String line : entityLines) {
                g2d.drawString(line, entityX, entityY);
                entityY += lineHeight;
            }
        }
    }

    public void setMapText(String text) {
        this.mapText = text;
        repaint();
    }

    public void setTimeText(String text) {
        this.timeText = text;
        repaint();
    }

    public void setEntitiesText(String text) {
        this.entitiesText = text;
        repaint();
    }
}

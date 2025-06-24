package org.generation.italy.sudProject.map;

import javax.swing.*;
import java.awt.*;

public class MapPanel extends JPanel {

    private String mapText = "";

    public void setMapText(String text) {
        this.mapText = text;
        repaint();  // ridisegna automaticamente ogni volta che cambia il testo
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(255, 165, 0)); // arancione
        g2d.setFont(new Font("Monospaced", Font.PLAIN, 14));

        FontMetrics fm = g2d.getFontMetrics();
        String[] lines = mapText.split("\n");

        int lineHeight = fm.getHeight();
        int totalHeight = lines.length * lineHeight;
        int y = (getHeight() - totalHeight) / 2 + fm.getAscent();

        for (String line : lines) {
            int lineWidth = fm.stringWidth(line);
            int x = (getWidth() - lineWidth) / 2;
            g2d.drawString(line, x, y);
            y += lineHeight;
        }
    }
}

package org.generation.italy.sudProject.map;

import org.generation.italy.sudProject.Entity;
import org.generation.italy.sudProject.TimeHandler;
import org.generation.italy.sudProject.TimePhase;
import org.generation.italy.sudProject.entities.Player;

import javax.swing.*;
import java.awt.*;

public class MapFrame extends JFrame {

    private MapPanel mapPanel;
    private static JTextArea messageLog;
    private static JTable statsTable;

    private JPanel playerStatsPanel;
    private JPanel rightPanel;
    private JPanel tablePanel;

    private JLabel nameLabel, lvlLabel, hpLabel, xpLabel, atkLabel, moneyLabel;
    private JLabel strLabel, dexLabel, conLabel, intLabel, wisLabel, chaLabel;

    public MapFrame() {
        setTitle("Mappa");
        setSize(1280, 920);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mapPanel = new MapPanel();

        // Log area
        messageLog = new JTextArea(8, 80);
        messageLog.setEditable(false);
        messageLog.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(messageLog);

        // Fight Stats Table
        String[] columnNames = {"Stat", "Fighter 1", "Fighter 2"};
        String[][] data = {
                {"Name", "", ""},
                {"HP", "", ""},
                {"XP", "", ""},
                {"Money", "", ""}
        };

        statsTable = new JTable(data, columnNames);
        statsTable.setEnabled(false);
        Font font = new Font("Monospaced", Font.PLAIN, 14);
        Font headerFont = new Font("Monospaced", Font.BOLD, 14);
        statsTable.setFont(font);
        statsTable.setRowHeight(30);
        statsTable.getTableHeader().setFont(headerFont);
        statsTable.setShowGrid(true);

        // Panel per la tabella
        tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(statsTable.getTableHeader(), BorderLayout.NORTH);
        tablePanel.add(statsTable, BorderLayout.CENTER);
        tablePanel.setMaximumSize(new Dimension(400, statsTable.getPreferredSize().height + 30));

        // Player Stats Panel
        playerStatsPanel = new JPanel(new GridLayout(0, 1, 0, 5));
        playerStatsPanel.setOpaque(true);
        playerStatsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        nameLabel = new JLabel();
        lvlLabel = new JLabel();
        hpLabel = new JLabel();
        xpLabel = new JLabel();
        atkLabel = new JLabel();
        moneyLabel = new JLabel();
        strLabel = new JLabel();
        dexLabel = new JLabel();
        conLabel = new JLabel();
        intLabel = new JLabel();
        wisLabel = new JLabel();
        chaLabel = new JLabel();

        JLabel[] labels = {
                nameLabel, lvlLabel, hpLabel, xpLabel, atkLabel, moneyLabel,
                strLabel, dexLabel, conLabel, intLabel, wisLabel, chaLabel
        };

        for (JLabel label : labels) {
            label.setFont(font);
            label.setOpaque(false);
            playerStatsPanel.add(label);
        }

        // Right panel
        rightPanel = new JPanel(new BorderLayout(0, 10));
        rightPanel.add(tablePanel, BorderLayout.NORTH);
        rightPanel.add(playerStatsPanel, BorderLayout.CENTER);

        // Layout principale
        setLayout(new BorderLayout());
        add(mapPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);
        add(rightPanel, BorderLayout.EAST);

        updateColorTheme();

        setVisible(true);
    }

    // Cambia dinamicamente il tema in base a TimePhase
    public void updateColorTheme() {
        Color bgColor;
        Color fgColor;

        if (TimeHandler.timePhase == TimePhase.DAY) {
            bgColor = Color.DARK_GRAY;
            fgColor = Color.WHITE;
        } else {
            bgColor = Color.BLACK;
            fgColor = new Color(255, 165, 0);
        }

        // Log
        messageLog.setBackground(bgColor);
        messageLog.setForeground(fgColor);

        // Tabella
        statsTable.setBackground(bgColor);
        statsTable.setForeground(fgColor);
        statsTable.setGridColor(fgColor);
        statsTable.getTableHeader().setForeground(fgColor);
        statsTable.getTableHeader().setBackground(bgColor);

        // Player stats
        playerStatsPanel.setBackground(bgColor);
        for (Component c : playerStatsPanel.getComponents()) {
            if (c instanceof JLabel label) {
                label.setForeground(fgColor);
            }
        }

        // Pannelli contenitori
        tablePanel.setBackground(bgColor);
        rightPanel.setBackground(bgColor);

        // Mappa
        mapPanel.repaint();

        // Frame container
        getContentPane().setBackground(bgColor);
    }

    public void updateMap(String mapText) {
        mapPanel.setMapText(mapText);
        updateColorTheme(); // Aggiorna anche i colori
    }

    public void updateTime(String timeText) {
        mapPanel.setTimeText(timeText);
    }

    public void updateEntities(String entitiesText) {
        mapPanel.setEntitiesText(entitiesText);
    }

    public static void appendToLog(String text) {
        messageLog.append(text + "\n");
        messageLog.setCaretPosition(messageLog.getDocument().getLength());
    }

    public static void setLog(String text) {
        messageLog.setText(text + "\n");
        messageLog.setCaretPosition(messageLog.getDocument().getLength());
    }

    public static void updateFightStats(Entity fighter1, Entity fighter2) {
        statsTable.setValueAt("Name", 0, 0);
        statsTable.setValueAt(fighter1.getName(), 0, 1);
        statsTable.setValueAt(fighter2.getName(), 0, 2);

        statsTable.setValueAt("HP", 1, 0);
        statsTable.setValueAt(String.valueOf(fighter1.getHp()), 1, 1);
        statsTable.setValueAt(String.valueOf(fighter2.getHp()), 1, 2);

        statsTable.setValueAt("XP", 2, 0);
        statsTable.setValueAt(String.valueOf(fighter1.getXp()), 2, 1);
        statsTable.setValueAt(String.valueOf(fighter2.getXp()), 2, 2);

        statsTable.setValueAt("Money", 3, 0);
        statsTable.setValueAt(String.valueOf(fighter1.getMoney()), 3, 1);
        statsTable.setValueAt(String.valueOf(fighter2.getMoney()), 3, 2);
    }

    public static void clearFightStats() {
        for (int row = 0; row < statsTable.getRowCount(); row++) {
            for (int col = 1; col < statsTable.getColumnCount(); col++) {
                statsTable.setValueAt("", row, col);
            }
        }
    }

    public void refreshPlayerStats(Player player) {
        nameLabel.setText("Nome: " + player.getPlayerName());
        lvlLabel.setText("Livello: " + player.getPlayerLevel());
        hpLabel.setText("HP: " + player.getHp() + " / " + player.getMaxHp());
        xpLabel.setText("XP: " + player.getXp() + " / " + player.getMaxXp());
        atkLabel.setText("ATK: " + player.getAtk());
        moneyLabel.setText("Money: " + player.getMoney());

        strLabel.setText("FOR: " + player.getStrength());
        dexLabel.setText("DES: " + player.getDexterity());
        conLabel.setText("COS: " + player.getConstitution());
        intLabel.setText("INT: " + player.getIntelligence());
        wisLabel.setText("SAG: " + player.getWisdom());
        chaLabel.setText("CAR: " + player.getCharisma());
    }
}

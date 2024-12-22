package Visuals;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.Timer;
import javax.swing.*;
import java.awt.*;

import javax.swing.JPanel;

public class CharacterHUD extends JPanel {
    private Image icon;
    private int health = 100;
    private int energy = 75;
    private int animationOffset = 0; // For simple animation

    public CharacterHUD(Image icon) {
        this.icon = icon;

        // Timer for icon animation
        Timer animationTimer = new Timer(100, e -> {
            animationOffset = (animationOffset + 1) % 5; // Simple bounce animation
            repaint();
        });
        animationTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw background
        g2d.setColor(new Color(50, 50, 50, 200));
        g2d.fillRoundRect(10, 10, 200, 80, 10, 10);

        // Draw character icon with animation
        g2d.drawImage(icon, 15, 15 + animationOffset, 50, 50, null);

        // Draw health bar
        g2d.setColor(Color.RED);
        g2d.fillRect(70, 20, health * 100 / 100, 10); // Scale bar width by health percentage

        // Draw energy bar
        g2d.setColor(Color.BLUE);
        g2d.fillRect(70, 40, energy * 100 / 100, 10); // Scale bar width by energy percentage

        // Draw text for stats
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 12));
        g2d.drawString("Health: " + health, 70, 17);
        g2d.drawString("Energy: " + energy, 70, 37);
    }

    // Update stats dynamically
    public void updateStats(int health, int energy) {
        this.health = health;
        this.energy = energy;
        repaint();
    }
}

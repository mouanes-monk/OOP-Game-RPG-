package Visuals;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

import game.charcters.Enemys.Enemeys;
import game.charcters.Player.Player;

public class playerturn extends JPanel {

    boolean moveChosen = false;
    private boolean delayTriggered = false;
    private boolean showPanel = false; // Controls whether the move panel is visible
    private int playerMove = 0; // 1: Attack, 2: Defend, 3: Dodge
    private Player player;

    private Enemeys enemy;

    // UI positions for clickable areas
    private int attackX = 10, attackY = 30, attackWidth = 180, attackHeight = 20;
    private int defendX = 10, defendY = 60, defendWidth = 180, defendHeight = 20;
    private int dodgeX = 10, dodgeY = 90, dodgeWidth = 180, dodgeHeight = 20;

    public playerturn(Player player, Enemeys enemy,keys key) {
        this.player = player;
        this.enemy = enemy;
       

        // Add mouse listener to detect clicks
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (showPanel && !moveChosen) {
                    int x = e.getX();
                    int y = e.getY();

                    if (isWithinBounds(x, y, attackX, attackY, attackWidth, attackHeight)) {
                        playerMove = 1; // Attack
                    } else if (isWithinBounds(x, y, defendX, defendY, defendWidth, defendHeight)) {
                        playerMove = 2; // Defend
                    } else if (isWithinBounds(x, y, dodgeX, dodgeY, dodgeWidth, dodgeHeight)) {
                        playerMove = 3; // Dodge
                    }

                    if (playerMove > 0) {
                        processPlayerMove(playerMove);
                        moveChosen = true;
                        System.out.println(""+  moveChosen);
                        showPanel = false; // Hide the panel after choosing a move
                        repaint();
                    }
                }
            }
        });

        setOpaque(false); // Ensure background transparency
    }

    public void update() {
        if (!delayTriggered && !moveChosen) {
            delayTriggered = true;

            // Delay before showing the move selection panel
            Timer delayTimer = new Timer(1000, e -> {
                showPanel = true; // Show the panel after 1 second
                repaint();
                ((Timer) e.getSource()).stop();
            });
            delayTimer.setRepeats(false);
            delayTimer.start();
        }

        if (moveChosen) {
          
           
            delayTriggered = false;
        }

        player.updtaef(); // Update player actions
    }

    private boolean isWithinBounds(int x, int y, int rectX, int rectY, int rectWidth, int rectHeight) {
        return x >= rectX && x <= rectX + rectWidth && y >= rectY && y <= rectY + rectHeight;
    }

    private void processPlayerMove(int move) {
        switch (move) {
            case 1:
                player.attack(enemy);
                player.setAnimationState("attacking");
                System.out.println("Player chose to Attack!");
                player.returnstats();
                break;

            case 2:
                player.deffense();
               
        
               
          
                break;

            case 3:
                player.defense();
                player.setAnimationState("dodging");
                
                System.out.println("Player chose to Dodge!");
                player.returnstats();
                break;

            default:
                System.out.println("Invalid move!");
                break;
        }

        playerMove = 0; // Reset the move
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (showPanel) { // Only draw the panel if it's visible
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Draw semi-transparent panel
            g2d.setColor(new Color(0, 0, 0, 150));
            g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);

            // Draw text options
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Arial", Font.BOLD, 16));
            g2d.drawString("Choose your move:", 10, 20);
            g2d.drawString("1. Attack", attackX, attackY + attackHeight - 5);
            g2d.drawString("2. Defend", defendX, defendY + defendHeight - 5);
            g2d.drawString("3. Dodge", dodgeX, dodgeY + dodgeHeight - 5);
        }
    }}
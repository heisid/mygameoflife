package life;

import javax.swing.*;
import java.awt.*;

public class FieldPanel extends JPanel {
    int gridSize;
    boolean[][] state;

    public FieldPanel(boolean[][] state) {
        super();
        setBounds(20, 80, 400, 400);
        this.state = Util.cloneMatrix(state);
        this.gridSize = state[0].length;
    }

    public void setState(boolean[][] state) {
        int stateSize = state[0].length;
        if (this.state.length != stateSize) {
            this.state = new boolean[stateSize][stateSize];
            this.gridSize = stateSize;
        }
        this.state = Util.cloneMatrix(state);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension panelSize = this.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        for (int y = 0; y < gridSize; y++) {
            for (int x = 0; x < gridSize; x++) {
                if (state[y][x]) {
                    g2.fillRect(x * (panelSize.width/gridSize),
                               y * (panelSize.height/gridSize),
                               panelSize.width/gridSize - 1,
                               panelSize.height/gridSize - 1);
                } else {
                    g2.drawRect(x * (panelSize.width/gridSize),
                                y * (panelSize.height/gridSize),
                             panelSize.width / gridSize - 1,
                             panelSize.height / gridSize - 1);
                }
            }
        }
    }

}
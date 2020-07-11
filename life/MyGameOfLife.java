package life;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyGameOfLife extends JFrame {
    private final JLabel GenerationLabel;
    private final JLabel AliveLabel;
    private final FieldPanel fieldPanel;
    private final boolean[][] state = new boolean[1][1]; // just for the sake of FieldPanel construction

    public MyGameOfLife() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 540);
        setTitle("Game Of Life");
        setLayout(null);

        GenerationLabel = new JLabel();
        GenerationLabel.setText("Generation #0");
        GenerationLabel.setBounds(20, 10, 200, 30);
        add(GenerationLabel);

        AliveLabel = new JLabel();
        AliveLabel.setText("Alive: 0");
        AliveLabel.setBounds(20, 40, 200, 30);
        add(AliveLabel);

        fieldPanel = new FieldPanel(state);
        add(fieldPanel);

        setVisible(true);
    }

    public void setGenerationLabel(final int numOfGen) {
        GenerationLabel.setText("Generation #" + numOfGen);
    }

    public void setAliveLabel(final int numAlive) {
        AliveLabel.setText("Alive: " + numAlive);
    }

    public void draw(final boolean[][] state) {
        fieldPanel.setState(state);
        fieldPanel.repaint();
    }
}

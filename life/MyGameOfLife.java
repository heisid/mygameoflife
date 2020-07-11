package life;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class MyGameOfLife extends JFrame {
    private final JLabel GenerationLabel;
    private final JLabel AliveLabel;
    private final FieldPanel fieldPanel;
    private final boolean[][] state = new boolean[1][1]; // just for the sake of FieldPanel construction

    public MyGameOfLife() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 540);
        setMinimumSize(new Dimension(480, 540));
        setTitle("Game Of Life");
        setLayout(new BorderLayout(5,5));

        GenerationLabel = new JLabel();
        GenerationLabel.setText("Generation #0");
        //GenerationLabel.setBounds(20, 10, 200, 30);
        //add(GenerationLabel);

        AliveLabel = new JLabel();
        AliveLabel.setText("Alive: 0");
        //AliveLabel.setBounds(20, 40, 200, 30);
        //add(AliveLabel);

        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new GridLayout(1,2,2,2));
        statusPanel.add(GenerationLabel);
        statusPanel.add(AliveLabel);

        JLabel sizeTextLabel = new JLabel("Size");
        JTextField textSize = new JTextField();

        JLabel generationTextLabel = new JLabel("Generation");
        JTextField textGeneration = new JTextField();

        JLabel seedTextLabel = new JLabel("Seed");
        JTextField textSeed = new JTextField();

        JButton buttonStart = new JButton();
        buttonStart.setText("Start");

        JButton buttonPause = new JButton();
        buttonPause.setText("Pause");

        JPanel controlPanel = new JPanel();
        controlPanel.add(buttonStart);
        controlPanel.add(buttonPause);
        controlPanel.add(generationTextLabel);
        controlPanel.add(textGeneration);
        controlPanel.add(seedTextLabel);
        controlPanel.add(textSeed);
        controlPanel.add(sizeTextLabel);
        controlPanel.add(textSize);
        controlPanel.setLayout(new GridLayout(4,2,5,5));

        fieldPanel = new FieldPanel(state);

        add(controlPanel, BorderLayout.NORTH);
        add(fieldPanel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);

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

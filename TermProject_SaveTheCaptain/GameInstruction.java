import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class GameInstruction extends JFrame implements ActionListener {
    private JButton startGameButton;
    private JTextArea instructionText;
    private Clip clip;

    public GameInstruction() {
        setTitle("Game Instructions");
        setSize(700, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Here are the instructions for the game");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Copperplate", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBackground(Color.decode("#5C4033"));
        titleLabel.setOpaque(true);

        setInstructionText(new JTextArea("[ Game Objective: The goal of the game is to guess the letters of a secret word within 30 seconds to save the captain. A topic will be provided as a hint.\n" +
                "\n" +
                "How to Play:\n" +
                "\n" +
                "Guessing Letters: Click on the letters of the on-screen keyboard to guess which ones might be in the word.\n\n" +
                "Correct Guesses: If the guessed letter is correct, it replaces the star hiding the letter in the secret word. Each correct guess earns you 1 point.\n\n" +
                "Incorrect Guesses: Each wrong guess moves the captain one step closer to the ocean. The pirate will push the captain towards the edge of the ship.\n\n" +
                "End of Game: The game ends if the captain is pushed into the ocean after 6 incorrect guesses or if the time runs out.\n\n" +
                "\"The game is over after 6 tries or when the time is up.\"\n\n" +
                "So, Try to guess the word correctly before the captain is pushed into the ocean to win!. ]"));
        getInstructionText().setWrapStyleWord(true);
        getInstructionText().setLineWrap(true);
        getInstructionText().setEditable(false);
        getInstructionText().setMargin(new Insets(20, 20, 20, 20));
        getInstructionText().setFont(new Font("Copperplate", Font.ITALIC, 16));
        getInstructionText().setBackground(Color.decode("#5C4033"));
        getInstructionText().setForeground(Color.WHITE);

        setStartGameButton(new JButton("Let's Start the Game"));
        getStartGameButton().addActionListener(this);
        getStartGameButton().setPreferredSize(new Dimension(300, 60));

        add(titleLabel, BorderLayout.NORTH);
        add(new JScrollPane(getInstructionText()), BorderLayout.CENTER);
        add(getStartGameButton(), BorderLayout.SOUTH);

        setVisible(true);
        playBackgroundMusic("resources/Sugar High - Jeremy Korpas.wav");
    }

    private void playBackgroundMusic(String filePath) {
        try {
            URL audioURL = getClass().getClassLoader().getResource(filePath);
            if (audioURL == null) {
                System.out.println("Audio file not found: " + filePath);
                return;
            }
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioURL);
            setClip(AudioSystem.getClip());
            getClip().open(audioStream);
            getClip().loop(Clip.LOOP_CONTINUOUSLY);
            getClip().start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getStartGameButton()) {
            if (getClip() != null) {
                getClip().stop();
            }
            dispose();
            SwingUtilities.invokeLater(() -> {
                new ScoredHangman().setVisible(true);
            });
        }
    }

    // Getters and setters
    public JButton getStartGameButton() {
        return startGameButton;
    }

    public void setStartGameButton(JButton startGameButton) {
        this.startGameButton = startGameButton;
    }

    public JTextArea getInstructionText() {
        return instructionText;
    }

    public void setInstructionText(JTextArea instructionText) {
        this.instructionText = instructionText;
    }

    public Clip getClip() {
        return clip;
    }

    public void setClip(Clip clip) {
        this.clip = clip;
    }
}
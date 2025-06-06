import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class Hangman extends Game {

    private static int timeRemaining = 30;
    private static JLabel timerLabel;
    private static Timer timer;
    private Clip clip;

    public Hangman() {
        super("Save The Captain");
    }

    @Override
    protected void addGuiComponents() {
        // Hangman image
        setHangmanImage(CustomTools.loadImage(CommonConstants.IMAGE_PATH));
        getHangmanImage().setBounds(0, 0, getHangmanImage().getPreferredSize().width, 300);

        //timer
        timerLabel = new JLabel("Time remaining", SwingConstants.CENTER);
        timerLabel.setBounds(450, 10, 300, 50);
        timerLabel.setFont(getCustomFont().deriveFont(18f));

        // Calculate the starting y position for the components below the image
        int yPosition = 300;

        // Category display
        setCategoryLabel(new JLabel(getWordChallenge()[0]));
        getCategoryLabel().setFont(getCustomFont().deriveFont(30f));
        getCategoryLabel().setHorizontalAlignment(SwingConstants.CENTER);
        getCategoryLabel().setOpaque(true);
        getCategoryLabel().setForeground(Color.BLACK);
        getCategoryLabel().setBackground(CommonConstants.SECONDARY_COLOR);
        getCategoryLabel().setBorder(BorderFactory.createLineBorder(CommonConstants.SECONDARY_COLOR));
        getCategoryLabel().setBounds(
                0,
                yPosition,
                CommonConstants.FRAME_SIZE.width,
                getCategoryLabel().getPreferredSize().height
        );

        // Update the yPosition after adding categoryLabel
        yPosition += getCategoryLabel().getPreferredSize().height;

        // Hidden word display
        setHiddenWordLabel(new JLabel(CustomTools.hideWords(getWordChallenge()[1])));
        getHiddenWordLabel().setFont(getCustomFont().deriveFont(64f));
        getHiddenWordLabel().setForeground(Color.WHITE);
        getHiddenWordLabel().setHorizontalAlignment(SwingConstants.CENTER);
        getHiddenWordLabel().setBounds(
                0,
                yPosition,
                CommonConstants.FRAME_SIZE.width,
                getHiddenWordLabel().getPreferredSize().height
        );

        // Update the yPosition after adding hiddenWordLabel
        yPosition += getHiddenWordLabel().getPreferredSize().height + 30;

        // Letter buttons panel
        GridLayout gridLayout = new GridLayout(4, 7);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(
                0,
                yPosition,
                CommonConstants.BUTTON_PANEL_SIZE.width,
                CommonConstants.BUTTON_PANEL_SIZE.height
        );
        buttonPanel.setLayout(gridLayout);

        // Create the letter buttons
        for (char c = 'A'; c <= 'Z'; c++) {
            JButton button = new JButton(Character.toString(c));
            button.setBackground(CommonConstants.PRIMARY_COLOR);
            button.setFont(getCustomFont().deriveFont(22f));
            button.setForeground(Color.BLACK);
            button.addActionListener(this);

            int currentIndex = c - 'A';
            getLetterButtons()[currentIndex] = button;
            buttonPanel.add(getLetterButtons()[currentIndex]);
        }

        // Reset button
        JButton resetButton = new JButton("Reset");
        resetButton.setFont(getCustomFont().deriveFont(22f));
        resetButton.setForeground(Color.BLACK);
        resetButton.setBackground(CommonConstants.SECONDARY_COLOR);
        resetButton.addActionListener(this);
        buttonPanel.add(resetButton);

        // Quit button
        JButton quitButton = new JButton("Quit");
        quitButton.setFont(getCustomFont().deriveFont(22f));
        quitButton.setForeground(Color.BLACK);
        quitButton.setBackground(CommonConstants.SECONDARY_COLOR);
        quitButton.addActionListener(this);
        buttonPanel.add(quitButton);

        startCountdownTimer();

        // Add components to the frame
        getContentPane().add(timerLabel);
        getContentPane().add(getCategoryLabel());
        getContentPane().add(getHangmanImage());
        getContentPane().add(getHiddenWordLabel());
        getContentPane().add(buttonPanel);

        playBackgroundMusic("resources/Sugar High - Jeremy Korpas.wav");
    }

    public void startCountdownTimer() {
        if (timer != null) {
            timer.stop();  // Ensure any existing timer is stopped
        }

        timeRemaining = 30;  // Reset to 30 seconds
        timerLabel.setText("Time Remaining: 00:30");

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeRemaining > 0) {
                    timeRemaining--;
                    int minutes = timeRemaining / 60;
                    int seconds = timeRemaining % 60;
                    timerLabel.setText(String.format("Time Remaining: %02d:%02d", minutes, seconds));
                } else {
                    ((Timer)e.getSource()).stop();
                    getResultLabel().setText("Time's up, Buddy!");
                    getResultDialog().setVisible(true);
                }
            }
        });

        timer.start();
    }

    private void playBackgroundMusic(String filePath) {
        try {
            // Load the audio file using the class loader to ensure the correct path
            URL audioURL = getClass().getClassLoader().getResource(filePath);
            if (audioURL == null) {
                System.out.println("Audio file not found: " + filePath);
                return;
            }
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioURL);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY); // Loop the music continuously
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(() -> {
            new ScoredHangman().setVisible(true);
        });
    }

    @Override
    protected void resetGame() {
        if (timer != null) {
            timer.stop();
        }
        timeRemaining = 30;  // Reset to 30 seconds
        timerLabel.setText("Time Remaining: 00:30");

        // Other reset logic
        setWordChallenge(getWordDB().loadChallenge());
        setIncorrectGuesses(0);

        CustomTools.updateImage(getHangmanImage(), CommonConstants.IMAGE_PATH);
        getCategoryLabel().setText(getWordChallenge()[0]);

        String hiddenWord = CustomTools.hideWords(getWordChallenge()[1]);
        getHiddenWordLabel().setText(hiddenWord);

        for(int i = 0; i < getLetterButtons().length; i++){
            getLetterButtons()[i].setEnabled(true);
            getLetterButtons()[i].setBackground(CommonConstants.PRIMARY_COLOR);
        }

        // Start a new countdown timer
        startCountdownTimer();
    }

    @Override
    public void createResultDialog() {
        setResultDialog(new JDialog());
        getResultDialog().setTitle("Result");
        getResultDialog().setSize(CommonConstants.RESULT_DIALOG_SIZE);
        getResultDialog().getContentPane().setBackground(CommonConstants.BACKGROUND_COLOR);
        getResultDialog().setResizable(true);
        getResultDialog().setLocationRelativeTo(this);
        getResultDialog().setModal(true);
        getResultDialog().setLayout(new GridLayout(3, 1));

        setResultLabel(new JLabel());
        getResultLabel().setForeground(Color.WHITE);
        getResultLabel().setHorizontalAlignment(SwingConstants.CENTER);

        setWordLabel(new JLabel());
        getWordLabel().setForeground(Color.WHITE);
        getWordLabel().setHorizontalAlignment(SwingConstants.CENTER);

        JButton restartButton = new JButton("Next Game");
        restartButton.setForeground(Color.BLACK);
        restartButton.setBackground(CommonConstants.SECONDARY_COLOR);
        restartButton.addActionListener(this);

        getResultDialog().add(getResultLabel());
        getResultDialog().add(getWordLabel());
        getResultDialog().add(restartButton);
    }

    // Getter and setter for static fields
    public static int getTimeRemaining() {
        return timeRemaining;
    }

    public static void setTimeRemaining(int time) {
        timeRemaining = time;
    }

    public static JLabel getTimerLabel() {
        return timerLabel;
    }

    public static void setTimerLabel(JLabel label) {
        timerLabel = label;
    }

    public static Timer getTimer() {
        return timer;
    }

    public static void setTimer(Timer t) {
        timer = t;
    }

    public Clip getClip() {
        return clip;
    }

    public void setClip(Clip c) {
        clip = c;
    }
}

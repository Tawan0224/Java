import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoredHangman extends Hangman {
    private int totalGamesPlayed = 0;
    private int gamesWon = 0;
    private JLabel scoreLabel;
    private boolean isTimeOut = false;
    private boolean isFirstGame = true;

    public ScoredHangman() {
        super();
        incrementGamesPlayed();
    }

    @Override
    protected void addGuiComponents() {
        super.addGuiComponents();
        createResultDialog();
    }

    @Override
    protected void resetGame() {
        super.resetGame();

        if (!isTimeOut && !isFirstGame) {
            incrementGamesPlayed();
        }
        setTimeOut(false);
        setFirstGame(false);
        updateScoreLabel();
    }

    private void incrementGamesPlayed() {
        setTotalGamesPlayed(getTotalGamesPlayed() + 1);
        updateScoreLabel();
    }

    @Override
    public void createResultDialog() {
        setResultDialog(new JDialog());
        getResultDialog().setTitle("Result");
        getResultDialog().setSize(new Dimension(400, 200));
        getResultDialog().setResizable(false);
        getResultDialog().setLocationRelativeTo(this);
        getResultDialog().setModal(true);
        getResultDialog().setLayout(new GridLayout(4, 1));

        setResultLabel(new JLabel());
        getResultLabel().setForeground(Color.BLACK);
        getResultLabel().setHorizontalAlignment(SwingConstants.CENTER);

        setWordLabel(new JLabel());
        getWordLabel().setForeground(Color.BLACK);
        getWordLabel().setHorizontalAlignment(SwingConstants.CENTER);

        setScoreLabel(new JLabel());
        getScoreLabel().setForeground(Color.BLACK);
        getScoreLabel().setHorizontalAlignment(SwingConstants.CENTER);
        updateScoreLabel();

        JButton restartButton = new JButton("Restart");
        restartButton.setForeground(Color.BLACK);
        restartButton.setBackground(Color.GRAY);
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getResultDialog().setVisible(false);
                setTotalGamesPlayed(1);
                setGamesWon(0);
                updateScoreLabel();
                resetGame();
            }
        });

        JButton nextGameButton = new JButton("Next Game");
        nextGameButton.setForeground(Color.BLACK);
        nextGameButton.setBackground(Color.GRAY);
        nextGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getResultDialog().setVisible(false);
                resetGame();
            }
        });

        getResultDialog().add(getResultLabel());
        getResultDialog().add(getWordLabel());
        getResultDialog().add(getScoreLabel());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(restartButton);
        buttonPanel.add(nextGameButton);
        getResultDialog().add(buttonPanel);
    }

    private void updateScoreLabel() {
        getScoreLabel().setText(String.format("Total Games Played: %d  |  Games Won: %d", getTotalGamesPlayed(), getGamesWon()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Reset") || command.equals("Restart")) {
            if (command.equals("Restart")) {
                setTotalGamesPlayed(1);
                setGamesWon(0);
                setFirstGame(true);
            }
            resetGame();
            if (command.equals("Restart")) {
                getResultDialog().setVisible(false);
            }
        } else if (command.equals("Quit")) {
            if (getTimer() != null) {
                getTimer().stop();
            }
            getClip().stop();
            dispose();
            return;
        } else {
            JButton button = (JButton) e.getSource();
            button.setEnabled(false);

            if (getWordChallenge()[1].contains(command)) {
                button.setBackground(Color.GREEN);

                char[] hiddenWord = getHiddenWordLabel().getText().toCharArray();
                for (int i = 0; i < getWordChallenge()[1].length(); i++) {
                    if (getWordChallenge()[1].charAt(i) == command.charAt(0)) {
                        hiddenWord[i] = command.charAt(0);
                    }
                }
                getHiddenWordLabel().setText(String.valueOf(hiddenWord));

                if (!getHiddenWordLabel().getText().contains("*")) {
                    getTimer().stop();
                    setGamesWon(getGamesWon() + 1);
                    getResultLabel().setText("You got it right!");
                    updateScoreLabel();
                    getResultDialog().setVisible(true);
                }
            } else {
                button.setBackground(Color.RED);
                setIncorrectGuesses(getIncorrectGuesses() + 1);
                CustomTools.updateImage(getHangmanImage(), "resources/" + (getIncorrectGuesses() + 1) + ".png");

                if (getIncorrectGuesses() >= 6) {
                    getTimer().stop();
                    getResultLabel().setText("Too Bad, Try Again?");
                    updateScoreLabel();
                    getResultDialog().setVisible(true);
                }
                getWordLabel().setText("Word: " + getWordChallenge()[1]);
            }
        }
    }

    // Getters and setters
    public int getTotalGamesPlayed() {
        return totalGamesPlayed;
    }

    public void setTotalGamesPlayed(int totalGamesPlayed) {
        this.totalGamesPlayed = totalGamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    public void setScoreLabel(JLabel scoreLabel) {
        this.scoreLabel = scoreLabel;
    }

    public boolean isTimeOut() {
        return isTimeOut;
    }

    public void setTimeOut(boolean timeOut) {
        isTimeOut = timeOut;
    }

    public boolean isFirstGame() {
        return isFirstGame;
    }

    public void setFirstGame(boolean firstGame) {
        isFirstGame = firstGame;
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class Game extends JFrame implements ActionListener {
    private int incorrectGuesses;
    private String[] wordChallenge;
    private JLabel hangmanImage, categoryLabel, hiddenWordLabel, resultLabel, wordLabel;
    private JButton[] letterButtons;
    private JDialog resultDialog;
    private Font customFont;
    private WordDB wordDB;

    public Game(String title) {
        super(title);
        setSize(CommonConstants.FRAME_SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(CommonConstants.BACKGROUND_COLOR);

        wordDB = new WordDB();
        letterButtons = new JButton[26];
        wordChallenge = wordDB.loadChallenge();
        customFont = CustomTools.createFont(CommonConstants.FONT_PATH);

        createResultDialog();
        addGuiComponents();
    }

    protected abstract void addGuiComponents();
    protected abstract void resetGame();
    protected abstract void createResultDialog();

    @Override
    public abstract void actionPerformed(ActionEvent e);

    // Getters and setters
    protected int getIncorrectGuesses() {
        return incorrectGuesses;
    }

    protected void setIncorrectGuesses(int incorrectGuesses) {
        this.incorrectGuesses = incorrectGuesses;
    }

    protected String[] getWordChallenge() {
        return wordChallenge;
    }

    protected void setWordChallenge(String[] wordChallenge) {
        this.wordChallenge = wordChallenge;
    }

    protected JLabel getHangmanImage() {
        return hangmanImage;
    }

    protected void setHangmanImage(JLabel hangmanImage) {
        this.hangmanImage = hangmanImage;
    }

    protected JLabel getCategoryLabel() {
        return categoryLabel;
    }

    protected void setCategoryLabel(JLabel categoryLabel) {
        this.categoryLabel = categoryLabel;
    }

    protected JLabel getHiddenWordLabel() {
        return hiddenWordLabel;
    }

    protected void setHiddenWordLabel(JLabel hiddenWordLabel) {
        this.hiddenWordLabel = hiddenWordLabel;
    }

    protected JLabel getResultLabel() {
        return resultLabel;
    }

    protected void setResultLabel(JLabel resultLabel) {
        this.resultLabel = resultLabel;
    }

    protected JLabel getWordLabel() {
        return wordLabel;
    }

    protected void setWordLabel(JLabel wordLabel) {
        this.wordLabel = wordLabel;
    }

    protected JButton[] getLetterButtons() {
        return letterButtons;
    }

    protected void setLetterButtons(JButton[] letterButtons) {
        this.letterButtons = letterButtons;
    }

    protected JDialog getResultDialog() {
        return resultDialog;
    }

    protected void setResultDialog(JDialog resultDialog) {
        this.resultDialog = resultDialog;
    }

    protected Font getCustomFont() {
        return customFont;
    }

    protected void setCustomFont(Font customFont) {
        this.customFont = customFont;
    }

    protected WordDB getWordDB() {
        return wordDB;
    }

    protected void setWordDB(WordDB wordDB) {
        this.wordDB = wordDB;
    }
}


import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class LaunchPage implements ActionListener {
    private JLabel label;
    private JFrame frame;
    private JButton myButton;
    private Clip clip;

    public LaunchPage() {
        setLabel(new JLabel());
        setFrame(new JFrame());
        setMyButton(new JButton("Start Game"));

        ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("resources/Startup-2.png"));

        getLabel().setIcon(image);
        getLabel().setBounds(0, 0, 700, 523);
        getFrame().add(getLabel());

        getMyButton().setBounds(250, 530, 200, 50);
        getMyButton().setFocusable(false);
        getMyButton().addActionListener(this);

        getFrame().add(getMyButton());

        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().setSize(700, 615);
        getFrame().setLayout(null);
        getFrame().setLocationRelativeTo(null);
        getFrame().setVisible(true);

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
        if (e.getSource() == getMyButton()) {
            getFrame().dispose();
            getClip().stop();
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new GameInstruction().setVisible(true);
                }
            });
        }
    }

    // Getters and setters
    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JButton getMyButton() {
        return myButton;
    }

    public void setMyButton(JButton myButton) {
        this.myButton = myButton;
    }

    public Clip getClip() {
        return clip;
    }

    public void setClip(Clip clip) {
        this.clip = clip;
    }
}



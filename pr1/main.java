import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
 * <applet code="Main" height=500 width=500></applet>
 * */
public class Main extends Applet {
    Button b1, b2;
    AudioClip ac;
    String str = "";

    public void init() {
        b1 = new Button("PLAY AUDIO 1");
        b2 = new Button("PLAY AUDIO 2");
        add(b1);
        add(b2);
        b1.addActionListener(this::actionPerformed);
        b2.addActionListener(this::actionPerformed);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            ac = getAudioClip(getCodeBase(), "1.wav");
            str = "Audio 1";
        } else if (ae.getSource() == b2) {
            ac = getAudioClip(getCodeBase(), "2.wav");
            str = "Audio 2";
        }
        ac.play();
        str += "\nPlayed!";
        repaint();
    }

    public void paint(Graphics g) {
        g.drawString(str, 100, 100);
    }
}
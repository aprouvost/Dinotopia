import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

public class PanelB extends JPanel {

  private Image backgroundImage;

  public PanelB(String fileName) throws IOException {
    backgroundImage = ImageIO.read(new File(fileName));
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Draw the background image.
    g.drawImage(backgroundImage, 0, 0, this);
  }
}

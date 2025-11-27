package problema.pkg8.rainhas;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import static problema.pkg8.rainhas.Constants.TABLE_ORDER;

/**
 *
 * @author Arnaldo Carneiro <acsn@a.recife.ifpe.edu.br>
 */
public class StatePanel extends JPanel
{
    private static final long serialVersionUID = -1273408574882848288L;

    private static final int ST_WIDTH = 366;
    private static final int ST_HEIGHT = 366;
    
    private final BufferedImage bImage;
    private static final String PATH = "images\\";
    private BufferedImage chessboard;
    private BufferedImage blackQueen;

    private State state;

    public StatePanel(State state)
    {
        this.state = state;
        this.bImage = new BufferedImage(ST_WIDTH, ST_HEIGHT, BufferedImage.TYPE_INT_RGB);
        try
        {
            this.chessboard = ImageIO.read(new File(PATH + "chessboard.png"));
        }
        catch(IOException ex)
        {
            Logger.getLogger(StatePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try
        {
            //this.blackQueen = ImageIO.read(new File(PATH + "black queen 1.png"));
            this.blackQueen = ImageIO.read(new File(PATH + "black queen 2.png"));
        }
        catch(IOException ex)
        {
            Logger.getLogger(StatePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        Graphics g = bImage.getGraphics();
        clearScreen(g);
        g.dispose();
    }

    public void setState(State state)
    {
        this.state = state;
    }

    private void clearScreen(Graphics g)
    {
        g.drawImage(chessboard, 0, 0, null);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        clearScreen(g);
        for(int i = 0; i < TABLE_ORDER; i++)
        {
            int j = this.state.getPosition(i);
            drawQueenAt(g, i, j);
        }
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(ST_WIDTH, ST_HEIGHT);
    }

    private void drawQueenAt(Graphics g, int i, int j)
    {
        g.drawImage(blackQueen, 23 + 40 * i, 23 + 40 * j, null);
    }
}
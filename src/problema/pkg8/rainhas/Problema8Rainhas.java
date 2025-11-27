package problema.pkg8.rainhas;

/**
 *
 * @author Arnaldo Carneiro <acsn@a.recife.ifpe.edu.br>
 */
public class Problema8Rainhas
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        startFrame();
    }

    private static void startFrame()
    {
        handleUI();
        
        java.awt.EventQueue.invokeLater(new FrameStarter());
    }

    private static void handleUI()
    {
        try
        {
            for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}

class FrameStarter implements Runnable
{
    @Override
    public void run()
    {
        new MainFrame().setVisible(true);
    }
}
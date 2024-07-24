import javax.swing.JFrame;

public class Main {

   // boolean running;

    

    public static void main(String[] args)
    {
        
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Pokemon Game");
        
        GUI gui = new GUI();

        window.add(gui);
        
        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        gui.startGameThread();

        
        
    }
    
}

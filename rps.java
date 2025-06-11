import javax.swing.*;
import java.awt.event.*;    // Needed for ActionListener
import java.awt.*;     
public class rps extends JFrame implements ActionListener{
    private JButton rockBtn;
    private JButton paperBtn;
    private JButton scissorBtn;
    String choices[]={"Rock","Paper","Scissors"};
    public rps(){
        setTitle("Rock Paper Scissors");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        rockBtn = new JButton("Rock");
        paperBtn = new JButton("Paper");
        scissorBtn = new JButton("Scissors");
        
        rockBtn.addActionListener(this);
        paperBtn.addActionListener(this);
        scissorBtn.addActionListener(this);
        
        JPanel panel = new JPanel();
        panel.add(rockBtn);
        panel.add(paperBtn);
        panel.add(scissorBtn);
        
        add(panel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String userChoice = e.getActionCommand();
        String computerChoice = choices[(int)(Math.random() * choices.length)];
        String result;
        if (userChoice.equals(computerChoice)) {
            result = "It's a tie!";
        } 
        else if ((userChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                   (userChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                   (userChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            result = "You win!";
        } 
        else {
            result = "You lose!";
        }
        JOptionPane.showMessageDialog(this, "Computer chose: " + computerChoice + "\n" + result);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            rps game = new rps();
            game.setVisible(true);
        });
    }
}
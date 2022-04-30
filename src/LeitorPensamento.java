import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class LeitorPensamento extends JFrame {
    private JSpinner txtVal;
    private JButton btnPalpite;
    private JLabel lblFrase;
    private JPanel mainPanel;

    public static void main(String[] args) {
        JFrame frame = new LeitorPensamento();
        frame.setVisible(true);
    }
    public LeitorPensamento() { //CONSTRUTOR
        lblFrase.setText("Vou pensar em um valor entre 1 e 5 tente adivinhar");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        btnPalpite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double n = 1+ Math.random() * (6-1);
                int valor = (int) n;
                int num = Integer.parseInt(txtVal.getValue().toString());
                String f1 = "ACERTOU!";
                String f2 = "Errou, eu pensei no valor" + valor;

                String res = (valor == num)? f1:f2;

                lblFrase.setText(res);


            }
        });
        txtVal.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);

                final JSpinner spinner = new JSpinner();
                spinner.setModel(new SpinnerNumberModel(1, 1, 5, 1));
            }
        });
    }
}




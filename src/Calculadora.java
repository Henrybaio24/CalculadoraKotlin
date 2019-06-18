import java.awt.*;
import javax.swing.*;

public class Calculadora extends JFrame {

    private JTextField visor;

    public Calculadora(){
        super("Calculadora");
        this.setSize(220, 280);
        JButton [] btNum = new JButton[10];
        for (byte i=0; i < btNum.length; i++) {
            final byte c = i;
            btNum[i] = new JButton(""+i);
            btNum[i].addActionListener(
                    actionEvent ->
                            visor.setText(KtCalculadoraKt.mostrar(c))
            );
        }
        JButton [] btAcciones = new JButton[6];
        final char [] acciones = {'+', '-', 'X', '=', 'C', '/'};
        for (int i = 0; i < btAcciones.length; i++){
            final char c = acciones[i];
            btAcciones [i] = new JButton(""+c);
            btAcciones [i].addActionListener(
                    actionEvent ->
                            visor.setText(KtCalculadoraKt.calcular(c))
            );
        }
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        final byte [][] num = {
                {7,8,9,0,4,5,6,1,1,2,3,2,0,3,4,5},
                {0,0,0,1,0,0,0,1,0,0,0,1,0,1,1,1}
        };
        for (int i = 0; i < num[0].length; i++){
            if (num[1][i]==0){
                panel.add(btNum[num[0][i]]);
            }else{
                panel.add(btAcciones[num[0][i]]);
            }
        }
        Font font1 = new Font("SanSerif", Font.BOLD, 20);
        visor = new JTextField("0.0");
        visor.setFont(font1);
        visor.setHorizontalAlignment(JTextField.RIGHT);
        visor.setEnabled(false);
        visor.setDisabledTextColor(Color.blue);

        this.add(panel);
        this.add(visor, BorderLayout.NORTH);
        this.setVisible(true);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    MyWindow() {
        setVisible(true);
        setLocation(330,180);
        setSize(1000,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Какое-то окно");
        JPanel panel = new JPanel(new GridLayout(1,2));
        JButton btn1 = new JButton("Выход");
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(btn1);
        JButton btn2 = new JButton("Второй выход");
        panel.add(btn2);
        add(panel, BorderLayout.SOUTH);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
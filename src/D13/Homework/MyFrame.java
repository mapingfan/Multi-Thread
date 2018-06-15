package D13.Homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    private final JButton executeButton = new JButton("Execute");
    private final JButton cancelButton = new JButton("Cancel");

    public MyFrame() {
        super("MyFrame");
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(new JLabel("Two-Phase Termination Sample"));
        getContentPane().add(executeButton);
        getContentPane().add(cancelButton);
        executeButton.addActionListener(this);
        cancelButton.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

//    Thread exeThread = new Thread(() -> Service.service());

    @Override
    public void actionPerformed(ActionEvent e) {
//        Thread canThread = new Thread(() -> Service.cancel());
        if (e.getSource() == executeButton) {
//            exeThread.start();
            Service.service();
        } else if (e.getSource() == cancelButton) {
//            Service.cancel(exeThread);
//            new Thread(() -> Service.cancel(exeThread)).start();
            Service.cancel();

        }
    }
}

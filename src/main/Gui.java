package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by simon on 9/20/16.
 */
public class Gui extends JFrame{
    private JTextArea textAreaBashOutput;
    private JButton btGetStatus;
    private JPanel rootPanel;
    private JButton btAllInOne;
    private JTextField TextFieldDirectory;
    private JButton button1;


    /*
    * Initializing gui for application
    * */
    public Gui() throws HeadlessException {
        super("Git Fast Pusher Delux)");
        Controller controller = new Controller();
        //set root JPanel
        setContentPane(rootPanel);
        //Causes this Window to be sized to fit the preferred size and layouts of its subcomponents.
//        pack();
//        Center application window location on screen
        setLocation(800,200);
        setSize(800,800);
//        close application on exit
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("yolo");
            }
        });
        btGetStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String returnText = controller.gitRequest(TextFieldDirectory.getText(), "status");
                textAreaBashOutput.setText(returnText);
            }
        });

        btAllInOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.gitRequest(TextFieldDirectory.getText(), "add .");
                controller.gitRequest(TextFieldDirectory.getText(), "commit -m 'initial commit' ");
                controller.gitRequest(TextFieldDirectory.getText(), "push origin master");
            }
        });

        //Set gui to be visible
        setVisible(true);
    }


}

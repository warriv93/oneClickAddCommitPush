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
        TextFieldDirectory.setText("/home/simon/IdeaProjects/gitHelper");


        btGetStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaBashOutput.setText("");
                String returnText = controller.gitRequest(TextFieldDirectory.getText(), "status");
                textAreaBashOutput.setText(returnText);
            }
        });

        btAllInOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaBashOutput.setText("");
                String returnText = controller.gitRequest(TextFieldDirectory.getText(), "add .");
                textAreaBashOutput.setText(returnText+"\n"+"\n");
                returnText += controller.gitRequest(TextFieldDirectory.getText(), "commit -m 'test commit' ");
                textAreaBashOutput.setText(returnText+"\n"+"\n");
                returnText += controller.gitPush(TextFieldDirectory.getText(), "push origin master", "warriv93", "jk75tdsd");
                textAreaBashOutput.setText(returnText);
            }
        });

        //Set gui to be visible
        setVisible(true);
    }


}

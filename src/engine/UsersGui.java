package engine;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 *
 * @author dpoumakis
 */
public class UsersGui
{
    private ArrayList<User> users;
    private Frame mainFrame;
    private Label headerLabel;
    private Label statusLabel;
    private Panel controlPanel;
    private Label msglabel;

    public UsersGui(ArrayList<User> users)
    {
        this.users = users;
        prepareGUI();
    }

    

    public void prepareGUI()
    {
        mainFrame = new Frame("UsersGUI");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(1, 1));
        mainFrame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }
        });
        headerLabel = new Label();
        headerLabel.setAlignment(Label.CENTER);
        statusLabel = new Label();
        statusLabel.setAlignment(Label.CENTER);
        statusLabel.setSize(350, 100);

        msglabel = new Label();
        msglabel.setAlignment(Label.CENTER);
        msglabel.setText("UsersGUI");

        controlPanel = new Panel();
        controlPanel.setLayout(new FlowLayout());

        // Test to add list stuff
        // Will need to loop to add people
        List lst = new List(4, false);
        
        for (User user : users)
        {
            lst.add(user.getUsername());
        }
        mainFrame.add(lst);

        //mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        //mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    public void showFrameDemo()
    {
        headerLabel.setText("Container in action: Frame");

        final Frame frame = new Frame();
        frame.setSize(300, 300);
        frame.setLayout(new FlowLayout());
        frame.add(msglabel);
        frame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent windowEvent)
            {
                frame.dispose();
            }
        });
        Button okButton = new Button("Open a Frame");

        okButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                statusLabel.setText("A Frame shown to the user.");
                frame.setVisible(true);
            }
        });
        controlPanel.add(okButton);

        mainFrame.setVisible(true);
    }
}

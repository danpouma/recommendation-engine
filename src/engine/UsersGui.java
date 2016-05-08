package engine;

import engineTest.UserDataStorageTest;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dpoumakis
 */
public class UsersGui
{

    private List userList;
    private List bookList;
    private ArrayList<User> users;
    private ArrayList<Book> books;
    private Frame mainFrame;
    private Label headerLabel;
    private Label statusLabel;
    private Panel controlPanel;
    private Label msglabel;

    public UsersGui(ArrayList<User> users, ArrayList<Book> books)
    {
        this.users = users;
        this.books = books;

        prepareGUI();
    }

    public void prepareGUI()
    {
        mainFrame = new Frame("UsersGUI");
        mainFrame.setSize(800, 600);
        mainFrame.setLayout(new GridLayout(1, 2));
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
        userList = new List(4, false);
        bookList = new List(4, false);

        for (User user : users)
        {
            userList.add(user.getUsername());
        }

        for (Book book : books)
        {
            bookList.add(book.getTitle());
        }
        mainFrame.add(userList);
        mainFrame.add(bookList);

        //mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        //mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    public void showFrameDemo()
    {
        headerLabel.setText("Container in action: Frame");

        final Frame frame = new Frame("y8");
        frame.setSize(600, 300);
        frame.setLayout(new GridLayout(1, 2));
        frame.add(msglabel);

        List list = new List();
        frame.add(list);

        frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent windowEvent)
            {
                frame.dispose();
            }
        });

        // Frame button for opening selected user
        Button userButton = new Button("Open user");

        userButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String username = userList.getSelectedItem();
                msglabel.setText(username);

                for (User user : users)
                {
                    if (user.getUsername().equals(username))
                    {
                        int count = 0;
                        for (Object rating : user.getRatings())
                        {
                            String currentBook = books.get(count).getTitle();
                            list.add(rating.toString() + "-->" + currentBook);
                            count++;
                        }
                    }

                }
                /*
                 Label bookTitle = new Label();
                 Label userRating = new Label();
                 for (int i = 0; i < 55; i++)
                 {
                 bookTitle.setText(books.get(i).getTitle());
                 userRating.setText((String) users.get(i).getRatings().get(i));
                    
                 //list.add(bookTitle.getText() + "->" + userRating.getText());
                    
                 }
                 statusLabel.setText("A Frame shown to the user.");
                 msglabel.setText(list.getItem(list.getSelectedIndex()));
                 System.out.println(msglabel.getText());
                 */
                frame.setVisible(true);
            }
        });
        controlPanel.add(userButton);

        // Frame button for opening selected user
        Button bookButton = new Button("Open book");

        bookButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                msglabel.setText(bookList.getSelectedItem());
                /*
                 Label bookTitle = new Label();
                 Label userRating = new Label();
                 for (int i = 0; i < 55; i++)
                 {
                 bookTitle.setText(books.get(i).getTitle());
                 userRating.setText((String) users.get(i).getRatings().get(i));
                    
                 //list.add(bookTitle.getText() + "->" + userRating.getText());
                    
                 }
                 statusLabel.setText("A Frame shown to the user.");
                 msglabel.setText(list.getItem(list.getSelectedIndex()));
                 System.out.println(msglabel.getText());
                 */
                frame.setVisible(true);
            }
        });
        controlPanel.add(bookButton);

        // Frame button for opening selected user
        Button addUserButton = new Button("Add user");

        addUserButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                NewUserGui addUser = new NewUserGui(users, books);

                // Try and store data into text file :)
                try
                {
                    UserDataStorage dataStore = new UserDataStorage(users);
                }
                catch (IOException ex)
                {
                    Logger.getLogger(UserDataStorageTest.class.getName()).log(Level.SEVERE, null, ex);
                }
                //frame.setVisible(true);
            }
        });
        controlPanel.add(addUserButton);

        mainFrame.setVisible(true);
    }
}

package engine;

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
public class EngineGui
{

    private List userList;
    private List bookList;
    private ArrayList<User> users;
    private ArrayList<Book> books;
    private Frame mainFrame;
    private Label statusLabel;
    private Panel controlPanel;
    private Label msglabel;

    public EngineGui(ArrayList<User> users, ArrayList<Book> books)
    {
        this.users = users;
        this.books = books;

        prepareGUI();
    }

    public void prepareGUI()
    {
        mainFrame = new Frame("Recommendation Engine! by Daniel Poumakis");
        mainFrame.setSize(800, 600);
        mainFrame.setLayout(new GridLayout(1, 2));
        mainFrame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }
        });
        statusLabel = new Label();
        statusLabel.setAlignment(Label.CENTER);
        statusLabel.setSize(350, 100);

        msglabel = new Label();
        msglabel.setAlignment(Label.CENTER);
        msglabel.setText("UsersGUI");

        controlPanel = new Panel();
        controlPanel.setLayout(new FlowLayout());

        // User && Book list
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
        mainFrame.add(controlPanel);
        mainFrame.setVisible(true);
    }

    public void showFrameDemo()
    {
        final Frame frame = new Frame();
        frame.setSize(600, 300);
        frame.setLayout(new GridLayout(1, 2));
        //frame.add(msglabel);

        List list = new List();
        frame.add(list);

        frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent windowEvent)
            {
                list.removeAll();
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
                frame.setTitle("User -> " + userList.getSelectedItem());
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
                frame.setTitle("Book -> " + bookList.getSelectedItem());
                frame.setVisible(true);
            }
        });
        controlPanel.add(bookButton);

        // Frame button for adding a new user
        Button addUserButton = new Button("Add user");

        addUserButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                AddUserGui addUser = new AddUserGui(users, books);

                try
                {
                    UserDataCollector dataStore = new UserDataCollector(users);
                }
                catch (IOException ex)
                {
                    Logger.getLogger(UserDataCollector.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Refresh the list
                userList.removeAll();
                for (User user : users)
                {
                    userList.add(user.getUsername());
                }
            }
        });
        controlPanel.add(addUserButton);

        // Frame button for adding a new book
        Button addBookButton = new Button("Add book");

        addBookButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                AddBookGui addBook = new AddBookGui(users, books);

                try
                {
                    UserDataCollector userDataStore = new UserDataCollector(users);
                    BookDataCollector bookDataStore = new BookDataCollector(books);
                }
                catch (IOException ex)
                {
                    Logger.getLogger(AddBookGui.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Refresh both lists
                userList.removeAll();
                for (User user : users)
                {
                    userList.add(user.getUsername());
                }
                bookList.removeAll();
                for (Book book : books)
                {
                    bookList.add(book.getTitle());
                }
            }
        });
        controlPanel.add(addBookButton);

        mainFrame.setVisible(true);
    }
}

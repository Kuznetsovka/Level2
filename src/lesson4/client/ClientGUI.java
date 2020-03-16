package lesson4.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ClientGUI extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler, KeyListener {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private final JTextArea log = new JTextArea();
    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JCheckBox cbAlwaysOnTop = new JCheckBox("Always on top");
    private final JTextField tfLogin = new JTextField("ivan");
    private final JPasswordField tfPassword = new JPasswordField("123");
    private final JButton btnLogin = new JButton("Login");
    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JButton btnDisconnect = new JButton("<html><b>Disconnect</b></html>");
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");
    private StringBuilder textLog = new StringBuilder("");
    private String prefix = System.getProperty("user.dir");
    private final String filePath = prefix + "/log.txt";
    private File file = new File(filePath);
    private final JList<String> userList = new JList<>();
    private Date date = new Date();
    private SimpleDateFormat formatForDateLog = new SimpleDateFormat("E yyyy.MM.dd 'время' k:mm:ss zzz");
    private SimpleDateFormat formatForDateChat = new SimpleDateFormat("k:mm:ss");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientGUI();
            }
        });
    }

    private ClientGUI() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat client");
        String[] users = {"user1", "user2", "user3", "user4", "user5",
                "user_with_an_exceptionally_long_name_in_this_chat"};
        userList.setListData(users);
        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        JScrollPane scrollUsers = new JScrollPane(userList);
        scrollUsers.setPreferredSize(new Dimension(100, 0));
        cbAlwaysOnTop.addActionListener(this);
        btnSend.addActionListener(this);
        tfMessage.addKeyListener(this);
        btnDisconnect.addActionListener(this);
        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(cbAlwaysOnTop);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        panelBottom.add(btnDisconnect, BorderLayout.WEST);
        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);
        add(scrollLog, BorderLayout.CENTER);
        add(scrollUsers, BorderLayout.EAST);
        add(panelTop, BorderLayout.NORTH);
        add(panelBottom, BorderLayout.SOUTH);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == cbAlwaysOnTop) {
            setAlwaysOnTop(cbAlwaysOnTop.isSelected());
        } else if (src == btnSend) {
            checkedFile(file);
            writeMessage(tfMessage.getText());
            tfMessage.setText("");
        } else if (src == btnLogin) {
            checkedFile(file);
        } else if (src == btnDisconnect) {
            log.setText("");
        } else
            throw new RuntimeException("Unknown source: " + src);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            checkedFile(file);
            writeMessage(tfMessage.getText());
            tfMessage.setText("");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    private void checkedFile(File file) {
        try {
            if (!file.exists())
            file.createNewFile();
        } catch (IOException ioe) {
            throw new RuntimeException("Файл не создан! Путь: " + filePath);
        }
    }

    private void writeMessage(String text) {
        if (text.equals("")) return;
        String textArea = log.getText() + addText(text, formatForDateChat);
        log.setText(textArea);
        writeToFile(filePath, addText(text, formatForDateLog));
    }

    private String addText(String txt, SimpleDateFormat formatD) {
        return formatD.format(date) + " " + tfLogin.getText() + ": " + txt + "\r\n";
    }

    private void writeToFile(String filePath, String text) {
        try {
            textLog.append(text);
            FileWriter fw = new FileWriter(filePath);
            fw.write(String.valueOf(textLog));
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        String msg;
        StackTraceElement[] ste = e.getStackTrace();
        msg = "Exception in thread " + t.getName() + " " +
                e.getClass().getCanonicalName() + ": " +
                e.getMessage() + "\n\t" + ste[0];
        JOptionPane.showMessageDialog(null, msg, "Exception", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }
}

package core_technology2.chapter4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Created by wangbin10 on 2019/1/7.
 */
public class InterruptibleSocketTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new InterruptibleSocketFrame();
                frame.setTitle("interruptible SocketTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * 一个框架，三个按钮，一个文本域
 */
class InterruptibleSocketFrame extends JFrame {
    private static final int TEXT_ROWS=40;
    private static final int TEXT_COLUMNS=60;
    private Scanner in;
    private JButton interruptibleButton;
    private JButton blockingButton;
    private JButton cancelButton;
    private JTextArea messages;
    private TextServer server;
    private Thread connectThread;

    public InterruptibleSocketFrame() throws HeadlessException {
        JPanel northPanel = new JPanel();
        add(northPanel, BorderLayout.NORTH);
        messages = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
        add(new JScrollPane(messages));
        interruptibleButton = new JButton("Interruptible");
        blockingButton = new JButton("Blocking");
        cancelButton = new JButton("cancel");
        cancelButton.setEnabled(false);
        northPanel.add(interruptibleButton);
        northPanel.add(blockingButton);
        northPanel.add(cancelButton);

        interruptibleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interruptibleButton.setEnabled(false);
                blockingButton.setEnabled(false);
                cancelButton.setEnabled(true);
                connectThread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            connectInterruptibly();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
                connectThread.start();
            }
        });
        blockingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interruptibleButton.setEnabled(false);
                blockingButton.setEnabled(false);
                cancelButton.setEnabled(true);
                connectThread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            connectBlocking();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
                connectThread.start();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectThread.interrupt();
                cancelButton.setEnabled(false);
            }
        });
        server=new TextServer();
        new Thread(server).start();
        pack();
    }

    private void connectInterruptibly() throws IOException {
        messages.append("Interruptible:\n");
        try (SocketChannel channel = SocketChannel.open(new InetSocketAddress("localhost", 8189))) {
            in = new Scanner(channel);
            while (!Thread.currentThread().isInterrupted()) {
                messages.append("reading ");
                if (in.hasNextLine()) {
                    String line=in.nextLine();
                    messages.append(line);
                    messages.append("\n");
                }
            }
        }finally {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    messages.append("Channel closed\n");
                    interruptibleButton.setEnabled(true);
                    blockingButton.setEnabled(true);
                }
            });
        }
    }

    private void connectBlocking() throws IOException {
        messages.append("Blocking:\n");
        try (Socket s = new Socket("localhost", 8189)) {
            in = new Scanner(s.getInputStream());
            while (!Thread.currentThread().isInterrupted()) {
                messages.append("reading ");
                if (in.hasNextLine()) {
                    String line=in.nextLine();
                    messages.append(line);
                    messages.append("\n");
                }
            }
        }finally {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    messages.append("Socket closed\n");
                    interruptibleButton.setEnabled(true);
                    blockingButton.setEnabled(true);
                }
            });
        }
    }

    class TextServer implements Runnable {
        @Override
        public void run() {
            try {
                ServerSocket s = new ServerSocket(8189);
                while (true) {
                    Socket incoming = s.accept();
                    Runnable r = new TextServerHandler(incoming);
                    Thread t = new Thread(r);
                    t.start();
                }
            } catch (IOException e) {
                messages.append("test server.run:"+e);
            }
        }
    }

    class TextServerHandler implements Runnable {
        private Socket incoming;
        private int counter;

        public TextServerHandler(Socket incoming) {
            this.incoming = incoming;
        }

        @Override
        public void run() {
            try {
                try {
                    OutputStream outputStream = incoming.getOutputStream();
                    PrintWriter out = new PrintWriter(outputStream, true);//持续刷新
                    while (counter < 100) {
                        counter++;
                        if (counter <= 10) {
                            out.println(counter);
                        }
                        Thread.sleep(100);
                    }
                } finally {
                    incoming.close();
                    messages.append("close server\n");
                }
            }
            catch (Exception e) {
                messages.append("test server handler.run:"+e);
            }
        }
    }
}




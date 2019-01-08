package core_technology2.chapter5;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by wangbin10 on 2019/1/8.
 */
public class ViewDB {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new ViewDBFrame();
                frame.setTitle("ViewDB");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class ViewDBFrame extends JFrame {
    private JButton previousButton;
    private JButton nextButton;
    private JButton deleteButton;
    private JButton saveButton;
    private DataPanel dataPanel;
    private Component scrollPane;
    private JComboBox<String> tableNames;
    private Properties props;
    private CachedRowSet crs;

    public ViewDBFrame() throws HeadlessException {
        tableNames = new JComboBox<String>();
        tableNames.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTable((String) tableNames.getSelectedItem());
            }
        });
        add(tableNames, BorderLayout.NORTH);

        try {
            readDatabaseProperties();
            try (Connection conn = getConnection()) {
                DatabaseMetaData metaData = conn.getMetaData();
                ResultSet mrs = metaData.getTables(null, null, null, new String[]{"Table"});
                while (mrs.next()) {
                    tableNames.addItem(mrs.getString(3));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e);
        }

        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);

        previousButton = new JButton("previous");
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    showPrviousRow();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        buttonPanel.add(previousButton);
        nextButton = new JButton("next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    showNextRow();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        buttonPanel.add(nextButton);
        deleteButton = new JButton("delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteRow();
            }
        });
        buttonPanel.add(deleteButton);
        saveButton = new JButton("save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    saveChanges();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        buttonPanel.add(saveButton);
        pack();


    }

    private void showTable(String tableName) {
        try (Connection conn = getConnection()) {
            Statement stat = conn.createStatement();
            ResultSet resultSet = stat.executeQuery("select * from " + tableName);
            RowSetFactory factory = RowSetProvider.newFactory();
            crs = factory.createCachedRowSet();
            crs.setTableName(tableName);
            crs.populate(resultSet);

            if (scrollPane != null) {
                remove(scrollPane);
            }
            dataPanel = new DataPanel(crs);
            scrollPane = new JScrollPane(dataPanel);
            add(scrollPane, BorderLayout.CENTER);
            validate();
            showNextRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showNextRow() throws SQLException {
        if (crs == null || crs.isLast()) {
            return;
        }
        crs.next();
        dataPanel.showRow(crs);
    }

    private void showPrviousRow() throws SQLException {
        if (crs == null || crs.isFirst()) {
            return;
        }
        crs.previous();
        dataPanel.showRow(crs);
    }

    private void deleteRow() {
        try {
            Connection conn = getConnection();
            crs.deleteRow();
            crs.acceptChanges(conn);
            if (crs.isAfterLast()) {
                if (!crs.isLast()) {
                    crs = null;
                }
            }
            dataPanel.showRow(crs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveChanges() throws SQLException {
        try (Connection conn = getConnection()) {
            dataPanel.setRow(crs);
            crs.acceptChanges(conn);
        }
    }

    private void readDatabaseProperties() throws IOException {
        props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("database.properites"))) {
            props.load(in);
        }
        String drivers = props.getProperty("jdbc.drivers");
        if (drivers != null) {
            System.setProperty("jdbc.drivers", drivers);
        }
    }

    private Connection getConnection() throws SQLException {
        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");
        return DriverManager.getConnection(url, username, password);
    }
}

class DataPanel extends JPanel {
    private java.util.List<JTextField> fields;

    public DataPanel(RowSet rs) throws SQLException {
        fields = new ArrayList<>();
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ResultSetMetaData metaData = rs.getMetaData();
        for (int i = 1; i < metaData.getColumnCount(); i++) {
            gbc.gridy = i - 1;
            String columnName = metaData.getColumnLabel(i);
            gbc.gridx = 0;
            gbc.anchor = GridBagConstraints.EAST;
            add(new JLabel(columnName), gbc);

            int columnWidth = metaData.getColumnDisplaySize(i);
            JTextField tb = new JTextField(columnWidth);
            if (!metaData.getColumnClassName(i).equals("java.lang.String")) {
                tb.setEnabled(false);
            }
            fields.add(tb);
            gbc.gridx = 1;
            gbc.anchor = GridBagConstraints.WEST;
            add(tb, gbc);
        }
    }

    public void showRow(RowSet rs) throws SQLException {
        for (int i = 1; i < fields.size(); i++) {
            String field = rs == null ? "" : rs.getString(i);
            JTextField tb = fields.get(i - 1);
            tb.setText(field);
        }
    }

    public void setRow(RowSet rs) throws SQLException {
        for (int i = 1; i < fields.size(); i++) {
            String field = rs.getString(i);
            JTextField tb = fields.get(i - 1);
            if (!field.equals(tb.getText())) {
                rs.updateString(i, tb.getText());
            }
        }
        rs.updateRow();
    }
}

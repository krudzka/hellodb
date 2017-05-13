package pl.sda;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by RENT on 2017-05-13.
 */
public class DataPanel extends JPanel {

    private JTable dataTAble;
    private JScrollPane dataScrollPane;

    public DataPanel() {
        super(new GridLayout(1, 1));
        dataTAble = new JTable();

        String[][] data = {{"a", "b", "c"},{"a", "b", "c"}};
        String[] columns = {"Imię", "Nazwisko", "Pesel"};

        dataTAble.setModel(new DefaultTableModel(data, columns));
        dataScrollPane = new JScrollPane(dataTAble);
        add(dataScrollPane);
    }

    public void fillWithDataByQuery (String query){
        MySQLService mySQLService = new MySQLService();
        String [][]data = mySQLService.getData(query);
        String [] columns = {"Imię","Imię","Nazwisko","Pesel","Imie","Nazwisko","Pesel"};
        dataTAble.setModel(new DefaultTableModel(data,columns));
    }
}

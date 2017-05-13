package pl.sda;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        MySQLService mySQLService = new MySQLService();
        mySQLService.printData("SELECT * FROM CUSTOMER");

        JFrame jFrame = new JFrame("Retarded SQL Workbench");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setMaximumSize(new Dimension(500, 500));

        DataPanel dataPanel = new DataPanel();
        dataPanel.fillWithDataByQuery("select*from customer");
        jFrame.setContentPane(dataPanel);
        jFrame.pack();
        jFrame.setVisible(true);


    }
}

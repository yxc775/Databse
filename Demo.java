package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        JPanel loginPanel = new JPanel(new FlowLayout());
        JFrame loginWindow = new JFrame("Login");
        loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame optionWindow = new JFrame("New Member");
        optionWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Connection conn = connect();
        loginWindow.getContentPane().add(loginPanel);
        JButton regButton = new JButton("register");
        loginPanel.add(regButton);
        JButton loginButton = new JButton("Login");
        loginPanel.add(loginButton);
        loginWindow.setVisible(true);
        loginWindow.setSize(400, 500);
        Random random = new Random();
        regButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel optionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                JButton restaurant = new JButton("New restaurant");
                JButton customer = new JButton("New customer");
                JButton deliver = new JButton("New deliver");
                optionPanel.add(restaurant);
                optionPanel.add(customer);
                optionPanel.add(deliver);
                optionWindow.getContentPane().add(optionPanel);
                optionWindow.setVisible(true);
                optionWindow.setSize(400,500);
                customer.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        registerCustomer(optionWindow,conn);
                    }
                });

                restaurant.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        registerRestaurant(optionWindow,conn);
                    }
                });

                deliver.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        registerDeliver(optionWindow,conn);
                    }
                });




            }

        });
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

    }



    /**
     * Connect to a sample database
     */
    public static Connection connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:/home/yxc775/Desktop/341/DLS3.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void registerCustomer(JFrame optionWindow,Connection conn){
        JFrame regWindow = new JFrame("New Customer");
        regWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel regPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel nameText = new JLabel("Name:");
        nameText.setFont(new Font("Arial", 1, 12));
        regPanel.add(nameText);

        JTextField nameInput = new JTextField(15);
        regPanel.add(nameInput);

        JLabel phoneText = new JLabel("Phone");
        phoneText.setFont(new Font("Arial", 1, 12));
        regPanel.add(phoneText);

        JTextField phoneInput = new JTextField(15);
        regPanel.add(phoneInput);

        regWindow.setVisible(true);

        regWindow.getContentPane().add(regPanel);
        regWindow.setSize(400,500);


        JButton confirmButton = new JButton("Confirm");
        regPanel.add(confirmButton);
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sql = "INSERT INTO Customer(cid,Name,PhoneNumber) values(?,?,?)";
                //I use hashCode for id.
                int i = nameInput.getText().hashCode() + phoneInput.getText().hashCode();
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setInt(1, i);
                    pstmt.setString(2, nameInput.getText());
                    pstmt.setDouble(3, Long.parseLong(phoneInput.getText()));
                    pstmt.executeUpdate();
                    System.out.println("added successfully");
                    regWindow.setVisible(false);
                    regWindow.dispose();
                    optionWindow.setVisible(false);
                    optionWindow.dispose();
                } catch (SQLException excep) {
                    JOptionPane.showMessageDialog(new JFrame("error"), "ERROR: An account already exists, error message: " + excep.getMessage());
                } catch (Exception exp) {
                    JOptionPane.showMessageDialog(new JFrame("error"), "ERROR: " + exp.getMessage());
                }
            }
        });
    }

    public static void registerRestaurant(JFrame optionWindow,Connection conn){
        JFrame regWindow = new JFrame("New Restaurant");
        regWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel regPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel nameText = new JLabel("Name:");
        nameText.setFont(new Font("Arial", 1, 12));
        regPanel.add(nameText);

        JTextField nameInput = new JTextField(15);
        regPanel.add(nameInput);

        JLabel phoneText = new JLabel("Phone");
        phoneText.setFont(new Font("Arial", 1, 12));
        regPanel.add(phoneText);

        JTextField phoneInput = new JTextField(15);
        regPanel.add(phoneInput);

        regWindow.setVisible(true);

        regWindow.getContentPane().add(regPanel);
        regWindow.setSize(400,500);


        JButton confirmButton = new JButton("Confirm");
        regPanel.add(confirmButton);
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sql = "INSERT INTO Customer(cid,Name,PhoneNumber) values(?,?,?)";
                //I use hashCode for id.
                int i = nameInput.getText().hashCode() + phoneInput.getText().hashCode();
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setInt(1, i);
                    pstmt.setString(2, nameInput.getText());
                    pstmt.setDouble(3, Long.parseLong(phoneInput.getText()));
                    pstmt.executeUpdate();
                    System.out.println("added successfully");
                    regWindow.setVisible(false);
                    regWindow.dispose();
                    optionWindow.setVisible(false);
                    optionWindow.dispose();
                } catch (SQLException excep) {
                    JOptionPane.showMessageDialog(new JFrame("error"), "ERROR: An account already exists, error message: " + excep.getMessage());
                } catch (Exception exp) {
                    JOptionPane.showMessageDialog(new JFrame("error"), "ERROR: " + exp.getMessage());
                }
            }
        });
    }

    public static void registerDeliver(JFrame optionWindow,Connection conn){
        JFrame regWindow = new JFrame("New Deliver");
        regWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel regPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel nameText = new JLabel("Name:");
        nameText.setFont(new Font("Arial", 1, 12));
        regPanel.add(nameText);

        JTextField nameInput = new JTextField(15);
        regPanel.add(nameInput);

        JLabel phoneText = new JLabel("Phone");
        phoneText.setFont(new Font("Arial", 1, 12));
        regPanel.add(phoneText);

        JTextField phoneInput = new JTextField(15);
        regPanel.add(phoneInput);

        regWindow.setVisible(true);

        regWindow.getContentPane().add(regPanel);
        regWindow.setSize(400,500);


        JButton confirmButton = new JButton("Confirm");
        regPanel.add(confirmButton);
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sql = "INSERT INTO Customer(cid,Name,PhoneNumber) values(?,?,?)";
                //I use hashCode for id.
                int i = nameInput.getText().hashCode() + phoneInput.getText().hashCode();
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setInt(1, i);
                    pstmt.setString(2, nameInput.getText());
                    pstmt.setDouble(3, Long.parseLong(phoneInput.getText()));
                    pstmt.executeUpdate();
                    System.out.println("added successfully");
                    regWindow.setVisible(false);
                    regWindow.dispose();
                    optionWindow.setVisible(false);
                    optionWindow.dispose();
                } catch (SQLException excep) {
                    JOptionPane.showMessageDialog(new JFrame("error"), "ERROR: An account already exists, error message: " + excep.getMessage());
                } catch (Exception exp) {
                    JOptionPane.showMessageDialog(new JFrame("error"), "ERROR: " + exp.getMessage());
                }
            }
        });
    }
}

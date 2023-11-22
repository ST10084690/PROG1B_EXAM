/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author lab_services_student
 */
public class EstateAgentGUI extends JFrame {
    private JComboBox<String> locationComboBox;
    private JTextField nameTextField, priceTextField, commissionTextField;
    private JTextArea reportTextArea;

    public EstateAgentGUI() {
        setTitle("Estate Agent Commission Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create GUI components
        locationComboBox = new JComboBox<>(new String[]{"Cape Town", "Durban", "Pretoria"});
        nameTextField = new JTextField();
        priceTextField = new JTextField();
        commissionTextField = new JTextField();
        reportTextArea = new JTextArea();
        JButton processButton = new JButton("Process Report");

        // Create menu bar and menus
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        JMenuItem processReportMenuItem = new JMenuItem("Process Report");
        JMenuItem clearMenuItem = new JMenuItem("Clear");
        JMenuItem saveReportMenuItem = new JMenuItem("Save Report");

        // Add components to the frame
        setLayout(new GridLayout(6, 2));
        add(new JLabel("Agent Location:"));
        add(locationComboBox);
        add(new JLabel("Agent Name:"));
        add(nameTextField);
        add(new JLabel("Property Price:"));
        add(priceTextField);
        add(new JLabel("Commission Percentage:"));
        add(commissionTextField);
        add(new JLabel(""));
        add(processButton);
        add(new JLabel("Estate Agent Report:"));
        add(new JScrollPane(reportTextArea));

        // Add menu items to menus
        fileMenu.add(exitMenuItem);
        toolsMenu.add(processReportMenuItem);
        toolsMenu.add(clearMenuItem);
        toolsMenu.add(saveReportMenuItem);

        // Add menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);

        // Set the menu bar for the frame
        setJMenuBar(menuBar);

        // Add action listeners
        exitMenuItem.addActionListener(e -> System.exit(0));
        processReportMenuItem.addActionListener(e -> processReport());
        clearMenuItem.addActionListener(e -> clearForm());
        saveReportMenuItem.addActionListener(e -> saveReport());

        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processReport();
            }
        });
    }

    private void processReport() {
        String location = (String) locationComboBox.getSelectedItem();
        String agentName = nameTextField.getText();
        String propertyPrice = priceTextField.getText();
        String agentCommission = commissionTextField.getText();

        EstateAgent estateAgent = new EstateAgent();
        if (estateAgent.validateData(location, agentName, propertyPrice, agentCommission)) {
            double commission = estateAgent.calculateCommission(propertyPrice, agentCommission);

            if (commission != -1) {
                String report = String.format("ESTATE AGENT REPORT\n" +
                        "******************************************\n" +
                        "AGENT LOCATION: %s\n" +
                        "AGENT NAME: %s\n" +
                        "PROPERTY PRICE: R %s\n" +
                        "COMMISSION PERCENTAGE: %s%%\n" +
                        "CALCULATED COMMISSION: R %.2f\n" +
                        "******************************************\n",
                        location, agentName, propertyPrice, agentCommission, commission);

                reportTextArea.setText(report);
            } else {
                JOptionPane.showMessageDialog(this, "Error in calculating commission. Please check input values.",
                        "Calculation Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid input data. Please check all fields.",
                    "Validation Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        locationComboBox.setSelectedIndex(0);
        nameTextField.setText("");
        priceTextField.setText("");
        commissionTextField.setText("");
        reportTextArea.setText("");
    }

    private void saveReport() {
        String report = reportTextArea.getText();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("report.txt"))) {
            writer.write(report);
            JOptionPane.showMessageDialog(this, "Report saved successfully", "Save Report",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving report to file.", "Save Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EstateAgentGUI gui = new EstateAgentGUI();
            gui.setVisible(true);
        });
    }
}
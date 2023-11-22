/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
class EstateAgent implements IEstateAgent {
    @Override
    public double calculateCommission(String propertyPrice, String agentCommission) {
        try {
            double price = Double.parseDouble(propertyPrice);
            double commissionPercentage = Double.parseDouble(agentCommission);
            return price * (commissionPercentage / 100);
        } catch (NumberFormatException e) {
            return -1; // Return -1 to indicate a calculation error
        }
    }

    @Override
    public boolean validateData(String location, String agentName, String propertyPrice, String agentCommission) {
        return !location.isEmpty() && !agentName.isEmpty()
                && Double.parseDouble(propertyPrice) > 0
                && Double.parseDouble(agentCommission) > 0;
    }
}

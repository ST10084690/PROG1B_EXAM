/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author lab_services_student
 */
public class EstateAgentTest {
    @Test
    public void calculateTotalSales_ReturnsTotalSales() {
        EstateAgent estateAgent = new EstateAgent();
        double[] propertySales = {800000, 1500000, 2000000};
        double totalSales = estateAgent.estateAgentSales(propertySales);
        assertEquals(4300000, totalSales, 0.001);
    }

    @Test
    public void calculateTotalCommission_ReturnsCommission() {
        EstateAgent estateAgent = new EstateAgent();
        double totalSales = 4300000; // Total sales for an agent
        double commission = estateAgent.estateAgentCommission(totalSales);
        assertEquals(86000, commission, 0.001);
    }

    @Test
    public void topAgent_ReturnsTopPosition() {
        EstateAgent estateAgent = new EstateAgent();
        double[] totalSales = {4300000, 3500000}; // Total sales for each agent
        int topAgent = estateAgent.topEstateAgent(totalSales);
        assertEquals(0, topAgent);
    }
}
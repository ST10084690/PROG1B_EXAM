/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Arrays;
/**
 *
 * @author lab_services_student
 */
class EstateAgent implements IEstateAgent {
    @Override
    public double estateAgentSales(double[] propertySales) {
        double totalSales = 0;
        for (double sale : propertySales) {
            totalSales += sale;
        }
        return totalSales;
    }

    @Override
    public double estateAgentCommission(double propertySales) {
        return 0.02 * propertySales;
    }

    @Override
    public int topEstateAgent(double[] totalSales) {
        int topAgent = 0;
        double maxSales = totalSales[0];
        for (int i = 1; i < totalSales.length; i++) {
            if (totalSales[i] > maxSales) {
                maxSales = totalSales[i];
                topAgent = i;
            }
        }
        return topAgent;
    }
}
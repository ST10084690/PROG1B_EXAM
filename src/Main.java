/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author lab_services_student
 */
public class Main {
    public static void main(String[] args) {
        double[][] propertySales = {
                {800000, 1500000, 2000000},
                {700000, 1200000, 1600000}
        };

        EstateAgent estateAgent = new EstateAgent();

        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("ESTATE AGENT SALES REPORT:");
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.printf("%-15s%-25s%-25s%-25s%n", "", "JAN", "FEB", "MARCH");
        System.out.println("-----------------------------------------------------------------------------------------------");

        String[] agentNames = {"Joe Bloggs", "Jane Doe"};
        double[] totalSales = new double[propertySales.length];
        double[] commissions = new double[propertySales.length];

        for (int i = 0; i < propertySales.length; i++) {
            System.out.printf("%-15s", agentNames[i]);
            for (double sale : propertySales[i]) {
                System.out.printf("R %-24.2f", sale);
            }
            System.out.println();

            totalSales[i] = estateAgent.estateAgentSales(propertySales[i]);
            commissions[i] = estateAgent.estateAgentCommission(totalSales[i]);
        }

        System.out.println("-----------------------------------------------------------------------------------------------");

        for (int i = 0; i < propertySales.length; i++) {
            System.out.printf("Total property sales for %s: R %.2f%n", agentNames[i], totalSales[i]);
        }

        for (int i = 0; i < propertySales.length; i++) {
            System.out.printf("Sales commission for %s: R %.2f%n", agentNames[i], commissions[i]);
        }

        int topAgentIndex = estateAgent.topEstateAgent(totalSales);
        System.out.printf("Top performing Estate Agent: %s%n", agentNames[topAgentIndex]);
        System.out.println("-----------------------------------------------------------------------------------------------");
    }
}

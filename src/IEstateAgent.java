/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
import java.util.Arrays;
/**
 *
 * @author lab_services_student
 */
interface IEstateAgent {
    double estateAgentSales(double[] propertySales);
    double estateAgentCommission(double propertySales);
    int topEstateAgent(double[] totalSales);
}


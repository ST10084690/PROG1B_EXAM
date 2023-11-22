/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author lab_services_student
 */
public class EstateAgentGUITest {
    @Test
    public void calculateCommission_CalculatedSuccessfully() {
        EstateAgent estateAgent = new EstateAgent();
        double commission = estateAgent.calculateCommission("800000", "10");
        assertEquals(80000, commission, 0.001);
    }

    @Test
    public void calculateCommission_CalculatedUnsuccessfully() {
        EstateAgent estateAgent = new EstateAgent();
        double commission = estateAgent.calculateCommission("Invalid", "10");
        assertEquals(-1, commission, 0.001);
    }

    @Test
    public void validationTest() {
        EstateAgent estateAgent = new EstateAgent();
        boolean isValid = estateAgent.validateData("Cape Town", "Joe Bloggs", "800000", "10");
        assertEquals(true, isValid);
    }
}
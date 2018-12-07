package cofre.cucumber;

import cofre.CofrePM;
import cofre.CofrePMTest;
import cofre.Memoria;
import cofre.SensorPorta;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author coelho
 */
public class SalvarSenhaSteps extends CofrePMTest {
    
    private String expectedDisplay = "";
    
    public SalvarSenhaSteps() {
        sensorMock = mock(SensorPorta.class);
        memoriaMock = mock(Memoria.class);
        cofrePM = new CofrePM(sensorMock, memoriaMock);    
        
        //porta sempre fechada
        when(sensorMock.fechada())
                .thenReturn(Boolean.TRUE); 
        
        //porta sempre destravada
        when(sensorMock.travada())
                .thenReturn(Boolean.FALSE);        
    }
    
    @Given("^cofre fechado$")
    public void cofre_fechado() throws Exception {
        assertTrue(sensorMock.fechada());
    }

    @Given("^cofre destravado$")
    public void cofre_destravado() throws Exception {
        assertFalse(sensorMock.travada());
    }

    @When("^pressionar \"([^\"]*)\"$")
    public void pressionar(String arg1) throws Exception {
        expectedDisplay += arg1;
        cofrePM.pressButton(Integer.parseInt(arg1));
        if(sensorMock.fechada())
            assertEquals(expectedDisplay, cofrePM.getDisplay());
        else
            assertEquals("Feche a porta antes de digitar a senha", cofrePM.getDisplay());
    }
    
    @Then("^display apresenta \"([^\"]*)\"$")
    public void display_apresenta(String arg1) throws Exception {
        assertEquals(arg1, cofrePM.getDisplay());
    }

    @When("^pressionar ok$")
    public void pressionar_ok() throws Exception {
        cofrePM.ok();
        assertTrue(sensorMock.fechada());
        assertFalse(sensorMock.travada());
    }

    @Then("^cofre trava$")
    public void cofre_trava() throws Exception {
        verify(sensorMock).travar();
        assertEquals("Senha salva. Cofre trancado", cofrePM.getDisplay());
    }

    @Then("^cofre salva senha \"([^\"]*)\"$")
    public void cofre_salva_senha(String arg1) throws Exception {
        verify(memoriaMock).salvarSenha(arg1);
        assertEquals("Senha salva. Cofre trancado", cofrePM.getDisplay());
    }
    
    @When("^abrir cofre$")
    public void abrir_cofre() throws Exception {
        when(sensorMock.fechada())
                .thenReturn(Boolean.FALSE);
    }

    @Then("^cofre aberto$")
    public void cofre_aberto() throws Exception {
        assertFalse(sensorMock.fechada());
    }
}

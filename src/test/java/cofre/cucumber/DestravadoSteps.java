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
public class DestravadoSteps extends CofrePMTest {

    public DestravadoSteps() {
        sensorMock = mock(SensorPorta.class);
        memoriaMock = mock(Memoria.class);
        cofrePM = new CofrePM(sensorMock, memoriaMock);
    }

    @Given("^que eu entrei no cofre com \"([^\"]*)\"$")
    public void que_eu_entrei_no_cofre_com(String arg1) throws Exception {
        cofrePM.pressButton(Integer.parseInt(arg1));
    }

    @Given("^que eu entrei para limpar o cofre$")
    public void que_eu_entrei_para_limpar_o_cofre() throws Exception {
        cofrePM.clear();
    }

    @Given("^o cofre não está fechado$")
    public void o_cofre_não_está_fechado() throws Exception {
        when(sensorMock.fechada())
                .thenReturn(Boolean.FALSE);
        assertEquals(false, sensorMock.fechada());
        cofrePM.ok();
    }

    @Given("^o cofre está fechado$")
    public void o_cofre_está_fechado() throws Exception {
        when(sensorMock.fechada())
                .thenReturn(Boolean.TRUE);
        assertEquals(true, sensorMock.fechada());
    }

    @When("^eu verificar o display$")
    public void eu_verificar_o_display() throws Exception {
        cofrePM.getDisplay();
    }

    @Then("^o resultado deve ser chamado o metodo destravar$")
    public void o_resultado_deve_ser_chamado_o_metodo_destravar() throws Exception {
        verify(sensorMock).destravar();
    }

    @Then("^o resultado deve ser \"([^\"]*)\"$")
    public void o_resultado_deve_ser(String arg1) throws Exception {
        assertEquals(arg1, cofrePM.getDisplay());
    }

}

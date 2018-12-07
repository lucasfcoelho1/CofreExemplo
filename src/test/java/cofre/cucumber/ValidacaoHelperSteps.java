/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cofre.cucumber;

import cofre.ValidacaoHelper;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author coelho
 */
public class ValidacaoHelperSteps {

    boolean result = false;
    String string = "";

    @Given("^que eu entrei com \"([^\"]*)\"$")
    public void que_eu_entrei_com(String string) throws Exception {
        this.string = string;
    }

    @When("^eu verificar se é um número$")
    public void eu_verificar_se_é_um_número() throws Exception {
        result = ValidacaoHelper.ehNumero(string);
    }

    @Then("^o resultado deve ser true$")
    public void o_resultado_deve_ser_true() throws Exception {
        assertEquals(true, result);
    }

    @Then("^o resultado deve ser false$")
    public void o_resultado_deve_ser_false() throws Exception {
        assertEquals(false, result);
    }

    @When("^eu verificar se a senha é valida$")
    public void eu_verificar_se_a_senha_é_valida() throws Exception {
        result = ValidacaoHelper.ehSenhaValida(string);
    }

}

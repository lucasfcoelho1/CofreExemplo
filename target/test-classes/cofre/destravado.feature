# language: en

Feature: Validação de testes do cofre
    quando ele se encontra destravado

Scenario: Digitar "123456" testando inicialização
    Given que eu entrei no cofre com "1"
    And que eu entrei no cofre com "2"
    And que eu entrei no cofre com "3"
    And que eu entrei no cofre com "4"
    And que eu entrei no cofre com "5"
    And que eu entrei no cofre com "6"
    When eu verificar o display
    Then o resultado deve ser chamado o metodo destravar

Scenario: Limpar display do cofre
    Given que eu entrei para limpar o cofre
    When eu verificar o display
    Then o resultado deve ser ""

Scenario: Digitar qualquer valor e o cofre não está fechado
    Given o cofre não está fechado 
    And que eu entrei no cofre com "2" 
    When eu verificar o display
    Then o resultado deve ser "Feche a porta antes de digitar a senha"

Scenario: Digitar qualquer valor e o cofre não está fechado
    Given o cofre não está fechado 
    And que eu entrei no cofre com "5" 
    When eu verificar o display
    Then o resultado deve ser "Feche a porta antes de digitar a senha"

Scenario: Digitar numero com porta fechada
    Given o cofre está fechado
    And que eu entrei no cofre com "1" 
    When eu verificar o display
    Then o resultado deve ser "1"

Scenario: Digitar numero com porta fechada
    Given o cofre está fechado
    And que eu entrei no cofre com "3" 
    When eu verificar o display
    Then o resultado deve ser "3"


#Paulo
Scenario: Salvar senha válida com porta fechada e destravada
    Given cofre fechado
    And cofre destravado
    When pressionar "1"
    Then display apresenta "1"
    When pressionar "9"
    Then display apresenta "19"
    When pressionar "3"
    Then display apresenta "193"
    When pressionar "5"
    Then display apresenta "1935"
    When pressionar "6"
    Then display apresenta "19356"
    When pressionar "6"
    Then display apresenta "193566"
    When pressionar ok
    Then cofre trava
    And cofre salva senha "193566"
    And display apresenta "Senha salva. Cofre trancado"
    
  Scenario: Digitar numero com menos de 6 digitos no cofre
      Given cofre fechado
      And cofre destravado
      When pressionar "1" 
      Then display apresenta "1"
      When pressionar ok
      Then display apresenta "senha precisa de 6 digitos. Tente novamente"

  Scenario: Digitar numero porta fechada e depois abrir e digitar
      Given cofre fechado
      And cofre destravado
      When pressionar "9" 
      Then display apresenta "9"
      When pressionar "8" 
      Then display apresenta "98"
      When abrir cofre
      Then cofre aberto
      When pressionar "7"
      Then display apresenta "Feche a porta antes de digitar a senha"

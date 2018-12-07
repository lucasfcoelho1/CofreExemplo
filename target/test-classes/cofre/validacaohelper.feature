# language: en

Feature: Validação dos numeros
  Como um usuario
  eu quero saber se um valor digitado é um número ou
  uma senha é válida

  Scenario: Digitar "123"
    Given que eu entrei com "123"
    When eu verificar se é um número
    Then o resultado deve ser true

  Scenario: Digitar "1234444"
    Given que eu entrei com "1234444"
    When eu verificar se é um número
    Then o resultado deve ser true
    
  Scenario: Digitar ""
    Given que eu entrei com ""
    When eu verificar se é um número
    Then o resultado deve ser false

  Scenario: Digitar "123aaaa"
    Given que eu entrei com "123aaaa"
    When eu verificar se é um número
    Then o resultado deve ser false

  Scenario: Digitar "123"
    Given que eu entrei com "123"
    When eu verificar se a senha é valida
    Then o resultado deve ser false

  Scenario: Digitar "1"
    Given que eu entrei com "1"
    When eu verificar se a senha é valida
    Then o resultado deve ser false

  Scenario: Digitar "12345"
    Given que eu entrei com "12345"
    When eu verificar se a senha é valida
    Then o resultado deve ser false

  Scenario: Digitar "12345a"
    Given que eu entrei com "12345a"
    When eu verificar se a senha é valida
    Then o resultado deve ser false

  Scenario: Digitar "123999"
    Given que eu entrei com "123999"
    When eu verificar se a senha é valida
    Then o resultado deve ser true


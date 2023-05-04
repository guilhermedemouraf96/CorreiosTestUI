#Author: your.email@your.domain.com

@buscaCEP
Feature: Busca CEP ou endereço	
  Como usuario
  Quero uma busca CEP ou endereço	
  Para visualizar endereço correspondente ao pesquisado

Background: Home Page
Given que esteja na tela inicial

  @positivo
  Scenario: CT1: Busca CEP valido
    When preencho cep valido
    Then endereço correspondente ao pesquisado
    
   @negativo
    Scenario: CT2: CEP em branco
     But não preencho CEP
     When clicar em buscar  
     Then visualizo erro
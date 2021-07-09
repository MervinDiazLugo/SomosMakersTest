Feature: Test Automation Somos Makers
  a característica consta de dos escenarios para automatizar, el primero consta de 4 registros que se deben almacenar
  en una base de datos para posteriormente hacer los calculos y cruzar con la información almacenada. El segundo escenario
  consta de un enunciado donde debera acceder a una pagina web y llenar un formulario de contactenos.

  Background:
    Given following parameters:
      | 15/05/2020 | OBL-MODER  | 123000  | 23.65   | 2908950  |
      | 16/05/2020 | OBL-MODER  | 10000   | 25.00   | 250000   |
      | 17/05/2020 | OBL-RIESGO | 1276987 | -10.20  | -13023267|
      | 18/05/2020 | OBL-RIESGO | 123000  | 1.29    | 160670   |

  @somosmakers
  Scenario: Calculos y cruce informacion
    When Calculate totals

  @somosmakers
  Scenario: Manejo de selenium
    Given I want to navigate in the site: https://somosmakers.co
    Then I load the DOM Information somosmakers.json
    When I click in element Menu_Contacto
    And I scroll to element Tel_Servicio_Cliente
    Then I Save text of Tel_Servicio_Cliente as Scenario Context
    Then I fill the form
    And I attach a Screenshot to Report
    And I click in element BTN_SEND
    




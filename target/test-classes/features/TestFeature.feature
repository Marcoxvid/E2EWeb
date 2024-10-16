Feature: Teste de Automação do site JSONPlaceholder

  Background: Acessar a página inicial e navegar até o guia
    Given eu acesso a página inicial "https://jsonplaceholder.typicode.com/guide/"
    When eu acesso o menu "Guide"

  Scenario: Navegar até o link de álbuns e validar dados do objeto com id 6
    When eu navego até o link "/albums/1/photos"
    Then eu capturo os dados exibidos em tela
    And eu valido os dados do objeto com id 6
      | title                                            | url                               | thumbnailUrl                          |
      | accusamus ea aliquid et amet sequi nemo | https://via.placeholder.com/600/56a8c2 | https://via.placeholder.com/150/56a8c2 |

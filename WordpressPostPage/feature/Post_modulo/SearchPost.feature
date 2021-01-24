
@SearchPost
Feature: SearchPost
  Deseo buscar un post en la tabla.

  @ButtonSearchPost
  Scenario: El boton 'Search' permite buscar un post y la tabla muestra los post derivados de la palabra buscada.
    Given Me encuentro en la pantalla Post
    When Escribo en el textbox la palabra 'h'
    Then Da click en el boton 'Search Post' y la tabla muestra los post buscados

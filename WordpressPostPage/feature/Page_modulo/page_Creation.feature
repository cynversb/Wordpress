
@CreatePage
Feature: CreatePage

  @ButtonPublishPage
  Scenario: El boton 'Publish' permite publicar 'Page' en la Web
  Given Me encuentro en la pagina principanl de 'Page'
  And Se da click en el boton 'Add New' para crear una pagina  
  When Se agrega titulo de 'Page'
  Then Se da click en el boton 'Publish' y se publica una 'Page'
    


@PublishPost
Feature: PublishPost

  @ButtonPublishWorks
  Scenario: El boton 'Publish' permite publicar el Post en la Web
  Given Me encuentro en la pagina 'Add Post'con link
  When Se agrega titulo y Se da click en el boton 'Publish'
  Then Se publica el Post en la Web

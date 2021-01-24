@EditPost
Feature: Edit post
  Realizar una edicion del post selecionando un post, selecionando opcion 'Edit' del combobox y dar clic en el boton 'Apply'

  @ButtonEditPost
  Scenario: Seleccionar el post y dar clic en la opcion 'Edit' del combo para editar el post- 
    Given Me encuentro en la pagina Post y selecciono un post
  	And Doy clic en la opcion Edit del combo
    When Se da clic en Apply y muestra la pantalla BULK EDIT 
    And Se edita las opciones Author,Comments,Pings y Status del post
    Then Se da clic en el boton Update y el post es actualizado.


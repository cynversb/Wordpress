@EditPage
Feature: EditPage

  @SelectEditPage
  Scenario: Se selecciona un 'Page' de la tabla y se da clic en la opcion 'Edit' del Combo para editar la 'Page' 
  Given Me encuentro en la pagina principanl de 'Page' y selecciono un Page
 	And Doy clic en la opcion Edit del combo en Page
  When Se da clic en Apply y muestra la pantalla BULK EDIT PAGE
  And Se edita las opciones Author,Comments,Pings y Status de page
  Then Se da clic en el boton Update y la Page es actualizada
  
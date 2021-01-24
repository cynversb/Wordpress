
@RemovePost
Feature: RemovePost
  I want to use this template for my feature file

  @ComboboxMovetoTrash
  Scenario: select a post and remove that post
    Given Me encuentro en la pagina principal de Post y selecciono un Post
    When Se da clic en el combobox 'Move to Trash'
    Then Se elimina el Post seleccionado
   

   


@RemovePage
Feature: RemovePage

  @ComboboxMovetoTrashPage
  Scenario: Se selecciona un Page y se da click en la opcion MovetoTrash del Combobox para eliminar la page.
    Given Me encuentro en la pagina principal de Page y selecciono una Page
    When Se da clic en el combobox 'Move to Trash' de Page
    Then Se elimina la Page seleccionada
   

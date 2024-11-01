Feature: Eliminación de Usuario

Scenario: Eliminar usuario exitosamente
  Given al navegar hasta la url "https://bridge.codepulso.com/"
  When hacer click en el campo de usuario "//*[@id='root']/section/section/div[2]/form/input"
  Then coloca en el campo usuario "//*[@id='root']/section/section/div[2]/form/input" el usuario "test"
  When hacer click en el campo de contraseña "//*[@id='root']/section/section/div[2]/form/div/input"
  And coloca en el campo contraseña "//*[@id='root']/section/section/div[2]/form/div/input" la contraseña "test123"
  And apretar boton de inicio sesion "//*[@id='root']/section/section/div[2]/form/button"
  And esperar el inicio de sesion "//*[@id='root']/div/nav/ul/a[1]"
  And hacer click en el modulo del menu llamado panel admin "//*[@id='root']/div/nav/ul/a[2]/li"
  And hacer click en el recurso llamado users "//*[@id='tab:r0:3']"
  And hacer click en ultima actividad para eliminar usuario inactivo "//*[@id='panel:r0:3']/div/div/section/div[2]/div[1]/table/thead/tr/th[5]"
  Then capturo el nombre del último usuario en la tabla
  And seleccionar el botón de eliminar del último usuario
  Then confirmo que el nombre en el modal es el mismo
  And apretar el boton de Eliminar "//*[@id='panel:r0:3']/div/div/div/div[2]/div/div/button[2]"
  Then confirmo que el usuario eliminado ya no está en la tabla

Scenario: Cancelar eliminación de usuario 
  Given al navegar hasta la url "https://bridge.codepulso.com/"
  When hacer click en el campo de usuario "//*[@id='root']/section/section/div[2]/form/input"
  Then coloca en el campo usuario "//*[@id='root']/section/section/div[2]/form/input" el usuario "test"
  When hacer click en el campo de contraseña "//*[@id='root']/section/section/div[2]/form/div/input"
  And coloca en el campo contraseña "//*[@id='root']/section/section/div[2]/form/div/input" la contraseña "test123"
  And apretar boton de inicio sesion "//*[@id='root']/section/section/div[2]/form/button"
  And esperar el inicio de sesion "//*[@id='root']/div/nav/ul/a[1]"
  And hacer click en el modulo del menu llamado panel admin "//*[@id='root']/div/nav/ul/a[2]/li"
  And hacer click en el recurso llamado users "//*[@id='tab:r0:3']"
  And hacer click en ultima actividad para eliminar usuario inactivo "//*[@id='panel:r0:3']/div/div/section/div[2]/div[1]/table/thead/tr/th[5]"
  Then capturo el nombre del último usuario en la tabla
  And seleccionar el botón de eliminar del último usuario
  Then confirmo que el nombre en el modal es el mismo
  And apretar el boton de Cancelar "//*[@id='panel:r0:3']/div/div/div/div[2]/div/div/button[1]"
  Then confirmo que el usuario no ha sido eliminado y está en la tabla

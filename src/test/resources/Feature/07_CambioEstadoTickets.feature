Feature: Cambio de Estado de Tickets

Scenario: Cambio de estado de Abierto a Cerrado
  Given al navegar hasta la url "https://bridge.codepulso.com/"
  When hacer click en el campo de usuario "//*[@id='root']/section/section/div[2]/form/input"
  Then coloca en el campo usuario "//*[@id='root']/section/section/div[2]/form/input" el usuario "test"
  When hacer click en el campo de contraseña "//*[@id='root']/section/section/div[2]/form/div/input"
  Then coloca en el campo contraseña "//*[@id='root']/section/section/div[2]/form/div/input" la contraseña "test123"
  Then apretar boton de inicio sesion "//*[@id='root']/section/section/div[2]/form/button"
  Then esperar el inicio de sesion "//*[@id='root']/div/nav/ul/a[1]"
  And hacer click en el modulo del menu llamado panel admin "//*[@id='root']/div/nav/ul/a[2]/li"
  And hacer click en el recurso llamado tickets "//*[@id='tab:r0:2']"
  Then esperar la lista de tickets "//*[@id='panel:r0:2']/div/div/section/div[2]/div[1]/table/tbody"
  Then ordenar lista de tickets "//*[@id='panel:r0:2']/div/div/section/div[2]/div[1]/table/thead/tr/th[3]"
  And abrir el ticket
  Then apretar el boton de resolver "//*[@id='panel:r0:2']/div/div/div/div[2]/div/button"
  Then insertar texto en el textarea "/html/body/section/section/form/textarea" el titulo "/html/body/section/h2"
  And cambiar el estado a cerrado "/html/body/section/section/form/label/select"
  Then hacer click en actualizar ticket "/html/body/section/section/form/button"
  
Scenario: Cambio de estado a En proceso
  Given al navegar hasta la url "https://bridge.codepulso.com/"
  When hacer click en el campo de usuario "//*[@id='root']/section/section/div[2]/form/input"
  Then coloca en el campo usuario "//*[@id='root']/section/section/div[2]/form/input" el usuario "test"
  When hacer click en el campo de contraseña "//*[@id='root']/section/section/div[2]/form/div/input"
  Then coloca en el campo contraseña "//*[@id='root']/section/section/div[2]/form/div/input" la contraseña "test123"
  Then apretar boton de inicio sesion "//*[@id='root']/section/section/div[2]/form/button"
  Then esperar el inicio de sesion "//*[@id='root']/div/nav/ul/a[1]"
  And hacer click en el modulo del menu llamado panel admin "//*[@id='root']/div/nav/ul/a[2]/li"
  And hacer click en el recurso llamado tickets "//*[@id='tab:r0:2']"
  Then esperar la lista de tickets "//*[@id='panel:r0:2']/div/div/section/div[2]/div[1]/table/tbody"
  Then ordenar lista de tickets "//*[@id='panel:r0:2']/div/div/section/div[2]/div[1]/table/thead/tr/th[3]"
  And abrir el ticket
  Then apretar el boton de resolver "//*[@id='panel:r0:2']/div/div/div/div[2]/div/button"
  Then insertar texto en el textarea "/html/body/section/section/form/textarea" el titulo "/html/body/section/h2"
  And cambiar el estado a enproceso "/html/body/section/section/form/label/select"
  Then hacer click en actualizar ticket "/html/body/section/section/form/button"

Scenario: Error al cambiar estado con comentario vacío
  Given al navegar hasta la url "https://bridge.codepulso.com/"
  When hacer click en el campo de usuario "//*[@id='root']/section/section/div[2]/form/input"
  Then coloca en el campo usuario "//*[@id='root']/section/section/div[2]/form/input" el usuario "test"
  When hacer click en el campo de contraseña "//*[@id='root']/section/section/div[2]/form/div/input"
  Then coloca en el campo contraseña "//*[@id='root']/section/section/div[2]/form/div/input" la contraseña "test123"
  Then apretar boton de inicio sesion "//*[@id='root']/section/section/div[2]/form/button"
  Then esperar el inicio de sesion "//*[@id='root']/div/nav/ul/a[1]"
  And hacer click en el modulo del menu llamado panel admin "//*[@id='root']/div/nav/ul/a[2]/li"
  And hacer click en el recurso llamado tickets "//*[@id='tab:r0:2']"
  Then esperar la lista de tickets "//*[@id='panel:r0:2']/div/div/section/div[2]/div[1]/table/tbody"
  Then ordenar lista de tickets "//*[@id='panel:r0:2']/div/div/section/div[2]/div[1]/table/thead/tr/th[3]"
  And abrir el ticket
  Then apretar el boton de resolver "//*[@id='panel:r0:2']/div/div/div/div[2]/div/button"
  Then hacer click en actualizar ticket "/html/body/section/section/form/button"
  Then esperar el mensaje de error solucion "/html/body/section/section/form/p"
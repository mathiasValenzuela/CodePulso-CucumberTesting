Feature: Habilitación de un Usuario

Scenario: Habilitar un usuario inactivo
  Given al navegar hasta la url "https://bridge.codepulso.com/"
  When hacer click en el campo de usuario "//*[@id='root']/section/section/div[2]/form/input"
  Then coloca en el campo usuario "//*[@id='root']/section/section/div[2]/form/input" el usuario "test"
  When hacer click en el campo de contraseña "//*[@id='root']/section/section/div[2]/form/div/input"
  Then coloca en el campo contraseña "//*[@id='root']/section/section/div[2]/form/div/input" la contraseña "test123"
  Then apretar boton de inicio sesion "//*[@id='root']/section/section/div[2]/form/button"
  Then esperar el inicio de sesion "//*[@id='root']/div/nav/ul/a[1]"
  And hacer click en el modulo del menu llamado panel admin "//*[@id='root']/div/nav/ul/a[2]/li"
  And hacer click en el recurso llamado users "//*[@id='tab:r0:3']"
  And esperar renderizar tabla "//*[@id='panel:r0:3']/div/div/section/div[2]/div[1]/table"
  And ordenar por rol "//*[@id='panel:r0:3']/div/div/section/div[2]/div[1]/table/thead/tr/th[3]"
  And ordenar por estado "//*[@id='panel:r0:3']/div/div/section/div[2]/div[1]/table/thead/tr/th[6]"
  Then accionar el boton editar del primer usuario "//*[@id='panel:r0:3']/div/div/section/div[2]/div[1]/table"
  And clickear el toggle "//*[@id='panel:r0:3']/div/div/div/div[2]/div/form/div[7]/label[2]/span"
  Then esperar el mensaje de exito "//*[@id='panel:r0:3']/div/div/div/div[2]/div/div/div/div"
Feature: Reporte Histórico de Tickets Creados

Scenario: Acceso al reporte histórico
  Given al navegar hasta la url "https://bridge.codepulso.com/"
  When hacer click en el campo de usuario "//*[@id='root']/section/section/div[2]/form/input"
  Then coloca en el campo usuario "//*[@id='root']/section/section/div[2]/form/input" el usuario "test"
  When hacer click en el campo de contraseña "//*[@id='root']/section/section/div[2]/form/div/input"
  And coloca en el campo contraseña "//*[@id='root']/section/section/div[2]/form/div/input" la contraseña "test123"
  And apretar boton de inicio sesion "//*[@id='root']/section/section/div[2]/form/button"
  And esperar el inicio de sesion "//*[@id='root']/div/nav/ul/a[1]"
  And hacer click en el modulo del menu llamado panel admin "//*[@id='root']/div/nav/ul/a[2]/li"
  And hacer click en el recurso llamado Tickets "//*[@id='tab:r0:2']"
  Then se visualiza el historial completo de tickets
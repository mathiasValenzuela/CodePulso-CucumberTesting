Feature: Proceso de Negocio - Resolución de Tickets

Scenario: Proceso de cierre de ticket sin respuesta
  Given al navegar hasta la url "https://bridge.codepulso.com/"
  When hacer click en el campo de usuario "//*[@id='root']/section/section/div[2]/form/input"
  Then coloca en el campo usuario "//*[@id='root']/section/section/div[2]/form/input" el usuario "test"
  When hacer click en el campo de contraseña "//*[@id='root']/section/section/div[2]/form/div/input"
  And coloca en el campo contraseña "//*[@id='root']/section/section/div[2]/form/div/input" la contraseña "test123"
  And apretar boton de inicio sesion "//*[@id='root']/section/section/div[2]/form/button"
  And esperar el inicio de sesion "//*[@id='root']/div/nav/ul/a[1]"
  And hacer click en el modulo del menu llamado panel admin "//*[@id='root']/div/nav/ul/a[2]/li"
  And hacer click en el recurso llamado Tickets "//*[@id='tab:r0:2']"
  And hacer click el botón de editar del último ticket registrado
  And hacer click el botón de resolver "//*[@id='panel:r0:2']/div/div/div/div[2]/div/button"
	And seleccionar en el combo desplegable opcion cerrado "/html/body/section/section/form/label/select/option[2]"
	And hacer click el botón de actualizar ticket "/html/body/section/section/form/button"
	Then visualizo mensaje debes presentar un solucion "/html/body/section/section/form/p"

Scenario: Visualización de ticket cerrado
  Given al navegar hasta la url "https://bridge.codepulso.com/"
  When hacer click en el campo de usuario "//*[@id='root']/section/section/div[2]/form/input"
  Then coloca en el campo usuario "//*[@id='root']/section/section/div[2]/form/input" el usuario "test"
  When hacer click en el campo de contraseña "//*[@id='root']/section/section/div[2]/form/div/input"
  And coloca en el campo contraseña "//*[@id='root']/section/section/div[2]/form/div/input" la contraseña "test123"
  And apretar boton de inicio sesion "//*[@id='root']/section/section/div[2]/form/button"
  And esperar el inicio de sesion "//*[@id='root']/div/nav/ul/a[1]"
  And hacer click en el modulo del menu llamado panel admin "//*[@id='root']/div/nav/ul/a[2]/li"
  And hacer click en el recurso llamado Tickets "//*[@id='tab:r0:2']"
  And hacer click en boton editar de un ticket que su estado sea cerrado
	Then visualizo estado y mensaje de usuario "//*[@id='panel:r0:2']/div/div/div/div[2]/div/textarea"

Scenario: Visualización de ticket en espera
  Given al navegar hasta la url "https://bridge.codepulso.com/"
  When hacer click en el campo de usuario "//*[@id='root']/section/section/div[2]/form/input"
  Then coloca en el campo usuario "//*[@id='root']/section/section/div[2]/form/input" el usuario "test"
  When hacer click en el campo de contraseña "//*[@id='root']/section/section/div[2]/form/div/input"
  And coloca en el campo contraseña "//*[@id='root']/section/section/div[2]/form/div/input" la contraseña "test123"
  And apretar boton de inicio sesion "//*[@id='root']/section/section/div[2]/form/button"
  And esperar el inicio de sesion "//*[@id='root']/div/nav/ul/a[1]"
  And hacer click en el modulo del menu llamado panel admin "//*[@id='root']/div/nav/ul/a[2]/li"
  And hacer click en el recurso llamado Tickets "//*[@id='tab:r0:2']"
  And hacer click en boton editar de un ticket que su estado sea abierto
	Then visualizo estado y mensaje de usuario "//*[@id='panel:r0:2']/div/div/div/div[2]/div/textarea"

Scenario: Actualizar historial de tickets
  Given al navegar hasta la url "https://bridge.codepulso.com/"
  When hacer click en el campo de usuario "//*[@id='root']/section/section/div[2]/form/input"
  Then coloca en el campo usuario "//*[@id='root']/section/section/div[2]/form/input" el usuario "test"
  When hacer click en el campo de contraseña "//*[@id='root']/section/section/div[2]/form/div/input"
  And coloca en el campo contraseña "//*[@id='root']/section/section/div[2]/form/div/input" la contraseña "test123"
  And apretar boton de inicio sesion "//*[@id='root']/section/section/div[2]/form/button"
  And esperar el inicio de sesion "//*[@id='root']/div/nav/ul/a[1]"
  And hacer click en el modulo del menu llamado panel admin "//*[@id='root']/div/nav/ul/a[2]/li"
  And hacer click en el recurso llamado Tickets "//*[@id='tab:r0:2']"
  And hacer click en el boton actualizar "//*[@id='panel:r0:2']/div/div/section/div[1]/button"
	Then visualizo refresh de tabla
	
Scenario: Proceso de gestionar ticket sin respuesta
  Given al navegar hasta la url "https://bridge.codepulso.com/"
  When hacer click en el campo de usuario "//*[@id='root']/section/section/div[2]/form/input"
  Then coloca en el campo usuario "//*[@id='root']/section/section/div[2]/form/input" el usuario "test"
  When hacer click en el campo de contraseña "//*[@id='root']/section/section/div[2]/form/div/input"
  And coloca en el campo contraseña "//*[@id='root']/section/section/div[2]/form/div/input" la contraseña "test123"
  And apretar boton de inicio sesion "//*[@id='root']/section/section/div[2]/form/button"
  And esperar el inicio de sesion "//*[@id='root']/div/nav/ul/a[1]"
  And hacer click en el modulo del menu llamado panel admin "//*[@id='root']/div/nav/ul/a[2]/li"
  And hacer click en el recurso llamado Tickets "//*[@id='tab:r0:2']"
  And hacer click el botón de editar del último ticket registrado
  And hacer click el botón de resolver "//*[@id='panel:r0:2']/div/div/div/div[2]/div/button"
	And hacer click el botón de actualizar ticket "/html/body/section/section/form/button"
	Then visualizo mensaje debes presentar un solucion "/html/body/section/section/form/p"

Scenario: Proceso de gestionar ticket correctamente
  Given al navegar hasta la url "https://bridge.codepulso.com/"
  When hacer click en el campo de usuario "//*[@id='root']/section/section/div[2]/form/input"
  Then coloca en el campo usuario "//*[@id='root']/section/section/div[2]/form/input" el usuario "test"
  When hacer click en el campo de contraseña "//*[@id='root']/section/section/div[2]/form/div/input"
  And coloca en el campo contraseña "//*[@id='root']/section/section/div[2]/form/div/input" la contraseña "test123"
  And apretar boton de inicio sesion "//*[@id='root']/section/section/div[2]/form/button"
  And esperar el inicio de sesion "//*[@id='root']/div/nav/ul/a[1]"
  And hacer click en el modulo del menu llamado panel admin "//*[@id='root']/div/nav/ul/a[2]/li"
  And hacer click en el recurso llamado Tickets "//*[@id='tab:r0:2']"
  And hacer click el botón de editar del último ticket registrado
  And hacer click el botón de resolver "//*[@id='panel:r0:2']/div/div/div/div[2]/div/button"
  And coloca en el campo de respuesta "/html/body/section/section/form/textarea" la respuesta "Estimado nuestro equipo de soporte se colocara en contacto con usted."
  And seleccionar en el combo desplegable opcion cerrado "/html/body/section/section/form/label/select/option[2]"
	And hacer click el botón de actualizar ticket "/html/body/section/section/form/button"
	Then visualizo mensaje cargando "/html/body/section/section/form/button"
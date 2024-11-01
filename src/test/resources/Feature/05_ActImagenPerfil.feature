Feature: Actualización de Imagen de Perfil

Scenario: Error en Actualización de imagen de perfil
  Given al navegar hasta la url "https://bridge.codepulso.com/"
  When hacer click en el campo de usuario "//*[@id='root']/section/section/div[2]/form/input"
  Then coloca en el campo usuario "//*[@id='root']/section/section/div[2]/form/input" el usuario "test"
  When hacer click en el campo de contraseña "//*[@id='root']/section/section/div[2]/form/div/input"
  Then coloca en el campo contraseña "//*[@id='root']/section/section/div[2]/form/div/input" la contraseña "test123"
  Then apretar boton de inicio sesion "//*[@id='root']/section/section/div[2]/form/button"
  Then esperar el inicio de sesion "//*[@id='root']/div/nav/ul/a[1]"
  And hacer click en perfil "//*[@id='root']/div/nav/div[2]/a"
	Then cargar archivo en el campo de carga de imagen "//*[@id='root']/div/main/section/section/div/button/input" con el archivo
	Then esperar mensaje de error "//*[@id='root']/div/main/section/section/p"
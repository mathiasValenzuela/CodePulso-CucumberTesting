Feature: Personalización de menú

Scenario: Visualizar contracción y descontracción del menu
  Given al navegar hasta la url "https://bridge.codepulso.com/"
  When hacer click en el campo de usuario "//*[@id='root']/section/section/div[2]/form/input"
  Then coloca en el campo usuario "//*[@id='root']/section/section/div[2]/form/input" el usuario "test"
  When hacer click en el campo de contraseña "//*[@id='root']/section/section/div[2]/form/div/input"
  And coloca en el campo contraseña "//*[@id='root']/section/section/div[2]/form/div/input" la contraseña "test123"
  And apretar boton de inicio sesion "//*[@id='root']/section/section/div[2]/form/button"
  And esperar el inicio de sesion "//*[@id='root']/div/nav/ul/a[1]"
  Then esperar carga de la pagina "//*[@id='root']/div/main/section/div"
  And hacer click en el icono superior del menu "//*[@id='root']/div/nav/div[1]/div"
  Then menu se contrae
	Then hacer click en el icono superior del menu "//*[@id='root']/div/nav/div[1]/div"
	Then menu se descontrae
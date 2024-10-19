Feature: Control de Acceso

  Scenario: Login con datos correctos
    Given al navegar hasta la url "https://bridge.codepulso.com/"
    When hacer click en el campo de usuario "//*[@id="root"]/section/section/div[2]/form/input"
    When coloca en el campo usuario "//*[@id="root"]/section/section/div[2]/form/input" el texto "test"
    Then apretar boton de inicio sesion "//*[@id="root"]/section/section/div[2]/form/button"
Feature: Control de Acceso

Scenario: Login con datos correctos
	Given al navegar hasta la url "https://demo.testfire.net/"
	When hacemos click en el link "//*[@id='LoginLink']/font"
	And coloca en el campo usuario "//*[@id='uid']" el texto "jsmith"
	And coloca en el campo password "//*[@id='passw']" el texto "Demo1234"
	And hacer click sobre el boton Login "//*[@id='login']/table/tbody/tr[3]/td[2]/input"
	And hacer click en el link Transfer Funds "//*[@id='MenuHyperLink3']"
	And hacer click en el boton Transfer Money "//*[@id='transfer']"
	Then Presenta el mensaje de alerta "From Account and To Account fields cannot be the same."


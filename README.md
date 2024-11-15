<em> # Conversor de Monedas JAVA </em>
<br>
Este es un proyecto challenge proporcionado por AluraLatam al participar en el programa ONE Oracle Next Education.
<br>
El objetivo de esta aplicación es utilizar la ExchageRate - API (https://www.exchangerate-api.com/)
para realizar conversiones de una moneda a la otra con la información proporcionada por dicha API.

<br><br>

Al iniciar la aplicación tendremos el siguiente menú:
<br>
![Menú inicial de la aplicación](https://github.com/user-attachments/assets/4c8a0a90-75ad-44cf-b78d-22905610b8a1)
<br>
Como vemos en el menú, tenemos diferentes opciones por defecto para elegir DESDE QUE moneda convertir, es decir,
la moneda que nosotros queremos convertir a otra.
<br>
Para este ejemplo se selecionará la opción número 1.

<br><br>

Una vez seleccionada una opción, nos desplegara el mismo menú con las mismas opciones.
<br>
![Menú secundario similar al menú inicial](https://github.com/user-attachments/assets/7c729889-0465-47ab-87f8-7049e56b9ecc)
<br>
Nuevamente tendremos opciones por defecto, donde seleccionaremos la opción correspondiente a la moneada 
A LA QUE QUEREMOS CONVERTIR, es decir, la moneda que nos interesa conocer el equivalente a la moneda
inicialmente seleccionada.
<br>
Para este ejemplo se seleccionará la opción número 2.

<br><br>

Luego de seleccionar las monedas, tanto desde la que queremos convertir y a la que queremos convertir,
el programa nos solicitará ingresar el monto correspondiente a la moneda inicial.
<br>
![Solicitud de monto a convertir](https://github.com/user-attachments/assets/f418e3c5-1828-4785-8cff-4dda1f92d91b)
<br>
Importante aclarar que si queremos añadir centavos(decimales) deben separarse con punto.
<br>
Ingresado el monto a convertir, el programa procederá a realizar la solicitud a la API
y realizará la conversión, mostrando tanto el monto ingresado y desde que moneda de convierte,
como también el resultado de la conversión y la moneda a la que se convirtió.

<br><br>

Volviendo al menú inicial...
<br>
![Menú inicial de la aplicación](https://github.com/user-attachments/assets/a0d01260-4940-429e-816a-7dbf9fcd3c69)
<br>
Podemos ver que, ademas de las opciones por defecto, tenemos una opción para ingresar nosotros mismos una moneda.
<br>
Dicha opción se encuentra disponible en ambos menús para ingresar la moneda que deseemos desde la cual convertir y a la cual convertir.
<br>
Si la seleccionamos, nos pedirá ingresar el código correspondiente a la moneda que queremos usar.
<br>
![Solicitud de código de moneda deseada](https://github.com/user-attachments/assets/caaded7b-087b-4cf2-a7ae-0c4340f8d250)
<br>
El código solicitado corresponde al Código de Moneda de Tres Caracteres ISO 4217.
<br>
Para un listado completo de estos códigos, puedes acceder al siguiente link de ExchangeRate donde
ademas de listar dichos códigos, también listan a que móneda corresponde cada código(https://www.exchangerate-api.com/docs/supported-currencies).
<br>
En este ejemplo utilizaremos el Dolar[USD] y el Sol Peruano[PEN].

<br><br>

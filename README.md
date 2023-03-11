# Actividad archivos

Dentro del proyecto se encuentran tres packages cada uno con una clase principal que contiene el método main resuelva los ejercicios enunciados a continuación en cada clase y paquete correspondiente.

> Nota: En la carpeta resource se encuentran algunos archivos necesarios para realizar cada punto. Lea con detenimiento cada punto para saber en donde se debe dejar la información o en donde se debe leer

> El fichero output contiene todos los archivos de salida (escritura).
> El fichero input contiene todos los archivos de entrada (lectura).
## Punto 1

Clone el respositorio usando el comando **git clone**

## Punto 2

Cree una rama con su nombre y ubiquese en ella puede usar el comando **git branch nombre-rama** y luego usar el comando **git checkout nombre-rama** o puede usar el comando **git checkout -b nombre-usuario**

## Punto 3

Lea el archivo texto.txt que se encuentra en la carpeta **src/resources/input/texto.txt** cuente el número de vocales que se encuentran en el archivo y usando un System.out,print muestre en pantalla el valor
> Nota: se debe tener en cuenta mayúsculas y minúsculas. Use el método de su preferencia para realizar la lectura del archivo.

## Punto 4

Cree una clase persona que contenga:
> - Nombres y Apellidos (String)
> - teléfono (String)
> - Salario (Double)
> - Edad (int)
> - Id (long)

Lea el fichero **src/resources/input/person.bin**, con los datos obtenidos cree objeto Persona y usando el método adecuado realice los siguentes cambios:
> - A la edad que tiene el usuario, restele 10,
> - Al Id multipliquelo por 2
> - Invierta el orden; ponga primero apellidos y luego nombres
> - Mantenga el valor del teléfono
> - El salario divídalo por 2 

registre la información del usuario en el archivo **src/resources/output/new-person.ddr**


> Nota: la estructura del archivo es Long que hace referencia al Id String que hace referencia a los nombres y apellidos String que hace referencia al teléfono Double que hace referencia al salario e Integer que hace referencia a la edad recuerde esta estructura al momento de leer el archivo.
> El nuevo archivo debe tener la estructura String (nombres y apellidos) Double (salario) Integer (edad) String (teléfono) y Long (Id)

## Punto 5

Lea el archivo **src/resources/input/base64.txt**, convierta el string que se encuentra en base64 a un arreglo de bytes u apoyándose en la clase DataOutputString genere un nuevo archivo con el nombre **imagen.jpg** este se debe ubicar en la ruta **src/resources/output**

> Nota: se puede apoyar en la clase Base64

## Punto 6

Obtenga el arreglo de bytes que genera el archivo **src/resources/input/940.jpg** codifíquelo a base64 y conviertalo en String posteriormente guarde ese string en un archivo llamado **940-base64.txt** el archivo se debe ubicar en la ruta **src/resources/output**

## Punto 7

Agregue los cambios usando el comando **git add .**

## Punto 8

Confirme los cambios usando el comando 
**git commit -m "commit description"**

## Punto 9

Suba los cambios a su rama usando el comando **git push **

 

# MicroservicioCalculadora

El microservicio expone un único recurso: operaciones sobre una única agrupación: calculadora.


La operación expuesta realiza (crea) una operación de cálculo, devolviendo el resultado de dicha operación. El path: calculadora/operaciones


Pongo un ejemplo de llamada en cURL:

curl --location --request POST 'http://localhost:8001/calculadora/operaciones' \
--header 'content-type: application/json' \
--data-raw '{
	"operacion": "RESTA",
	"miembroIzquierdo": 1.02,
	"miembroDerecho": 2.02
}'



El jar generado tras hacer "mvn install" en la raíz del proyecto se ejecuta de la siguiente manera para lanzar el servidor (escuchará puerto 8001, está configurado bajo propiedad pero de forma interna en el jar):

java -jar Calculadora-1.0.0.jar



Más cosas que se podrían haber hecho:
 - Aplicar git-flow como metodología Git
 - Hacerlo bajo Spring WebFlux (pero no sé si Sanitas admite proyectos bajo stack reactivo)
 - Preparar la jerarquía para aceptar múltiples operaciones hijas (patrón Composite debería ser el elegido)  -- Este si tengo tiempo, mañana lo hago (que me pica la curiosidad)
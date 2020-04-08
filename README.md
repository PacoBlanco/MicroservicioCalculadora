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


El jar generado tras hacer "mvn install" se ejecuta de la siguiente manera:
java -jar Calculadora-1.0.0.jar


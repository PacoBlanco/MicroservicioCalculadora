# MicroservicioCalculadora

El microservicio expone un único recurso: operaciones sobre una única agrupación: calculadora.


La firma del recurso expuesta calcula (crea un cálculo - POST) sobre una agrupación de operaciones de cálculo, devolviendo el resultado de dicha operación. El path: calculadora/operaciones

Por ejemplo, si queremos calcular: 1.01 - 3.03 - 1.01 - 3.03, debemos saber que el operador resto no es conmutativo e, internamente, debemos dar prioridad a la ejecución de los cálculos de izquierda a derecha por lo que la operación podría extenderse a lo siguente: (((1.01 - 3.03) - 1.0.1) - 3.03) y el cURL de esta operación sería:
curl --location --request POST 'http://localhost:8001/calculadora/operaciones' \
--header 'Content-Type: application/json' \
--data-raw '{
	"operacion": "RESTA",
	"miembroIzquierdo": {
		"operacion": "RESTA",
		"miembroIzquierdo": {
			"operacion": "RESTA",
			"miembroIzquierdo": 1.01,
			"miembroDerecho": 3.03
		},
		"miembroDerecho": 1.01
	},
	"miembroDerecho": 3.03
}'


Si, por ejemplo, queremos calcular: ((1.01 - 3.03) - (1.01 - 3.03)), mismos valores y operadores pero agrupados de forma diferente, el resultado es diferente y el cURL de esta operación sería:
curl --location --request POST 'http://localhost:8001/calculadora/operaciones' \
--header 'Content-Type: application/json' \
--data-raw '{
	"operacion": "RESTA",
	"miembroIzquierdo": {
		"operacion": "RESTA",
		"miembroIzquierdo": 1.01,
		"miembroDerecho": 3.03
	},
	"miembroDerecho":  {
		"operacion": "RESTA",
		"miembroIzquierdo": 1.01,
		"miembroDerecho": 3.03
	}
}'


El jar generado tras hacer "mvn install" en la raíz del proyecto se ejecuta de la siguiente manera para lanzar el servidor (escuchará puerto 8001, está configurado bajo propiedad pero de forma interna en el jar):

java -jar Calculadora-1.0.0.jar



Más cosas que se podrían haber hecho:
 - Aplicar git-flow como metodología Git
 - Hacerlo bajo Spring WebFlux (pero no sé si Sanitas admite proyectos bajo stack reactivo)
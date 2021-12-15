# Pasos para levantar el contenerdor de la imagen docker

# 1) Ubicarse en la Raíz del proyecto /ExchangeRate

# 2) Construir la imagen docker
$ docker build -t exchange-rate.jar .

# 3) Verificar la imagen docker 
$ docker image ls

# 4) Crear el contenedor 
$ docker run -p 9090:8080 exchange-rate.jar

En el comando de ejecución, se específico que el puerto 8080 en el contenedor 
debe asignarse al puerto 9090 en el sistema operativo host.

# 5) Importar el curl a un postman

curl --location --request POST 'localhost:8080/api/exchange' \
--header 'Content-Type: application/json' \
--data-raw '{
    "amount" : 32,
    "originCurrency" : "USD",
    "destinationCurrency" : "SOL"
}'

# 6) Colocar la ip del servidor por el localhost y el puerto reemplazarlo por el 9090

# 7) Probar el endpoint tipo de cambio /api/exchange
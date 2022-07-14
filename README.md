# Prueba Técnica Banco BCI

A continuación se deja documentación para ejecutar la prueba tecnica

### Requerimientos

- Java 8
- Servidor para ejecutar aplicaciones java
- Postman

## Autenticación
Para usar el aplicativo, se debe autenticar con las credenciales por defecto, llamando al endpoint con método _POST_:

```sh
http://localhost:8080/authenticate
```
Con cuerpo 
```sh
{
    "username":"admin",
    "password":"password"
}
```
ejemplo resultado
```sh
{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY1Nzg0MDI4NCwiaWF0IjoxNjU3ODIyMjg0fQ.QtgSikqehADofBfmWUaWKJlwW-26K8TFBSescoUlWmeeFKoB5CCW1zCd9zruNYqWDvova8C6IqF9SoE3H0EvWQ"
}
```

### Authorization
Para consultar los endpoint que se mencionan más adelante se debe ingresar el token obtenido anteriormente como autorización:
```sh
Authorization:Bearer <token>
```


## Insertar
Para insertar usuarios se debe llamar al endpoint con método _POST_:
```sh
http://localhost:8080/usuario
```
Ejemplo de mensaje a enviar
```sh
{
    "name": "Juan Rodriguez ",
    "email": "ffq.11q@fffgq.qwwe",
    "password": "AA2dssf!",
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
        }
    ]
}
```
Mensaje de respuesta del aplicativo:
```sh
{
    "id": "a21bb237-28e0-49ce-9fbb-827ee2dc3b93",
    "created": "2022-07-14 14:16:00",
    "modified": "",
    "last_login": "2022-07-14 14:16:00",
    "isActive": "true",
    "mensaje": "Usuario guardado con exito"
}
```
## Modificar
Para modificar usuarios se debe llamar al endpoint con método _PUT_:

```sh
http://localhost:8080/usuario
```
Ejemplo de mensaje a enviar
```sh
{
    "id": "87473aba-3020-43a1-82e2-114e43955923",
    "name": "Juan Rodriguez lopez",
    "email": "ffq@fffgq.qwwe",
    "password": "AA2dssf!",
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
        },
        {
            "number": "222222",
            "citycode": "6666",
            "contrycode": "7777"
        }
    ]
}
```

Mensaje de respuesta del aplicativo:

```sh
{
    "id": "87473aba-3020-43a1-82e2-114e43955923",
    "created": "2022-07-14 09:34:42",
    "modified": "2022-07-14 09:38:26",
    "last_login": "2022-07-14 09:34:42",
    "isActive": "true",
    "mensaje": "Usuario actualizado con exito"
}
```
## Eliminar
Para eliminar usuarios se debe llamar al endpoint con método _DELETE_:
```sh
http://localhost:8080/usuario
```
con parametros
```sh
id:<id-usuario>
```
## Obtener usuario específico
Para obtener usuarios específico se debe llamar al endpoint con método _GET_:
```sh
http://localhost:8080/usuario
```
con parametros
```sh
id:<id-usuario>
```
## Obtener todos los usuarios

Para obtener todos los usuarios se debe llamar al endpoint con método _GET_:
```sh
http://localhost:8080/usuario/get-all
```
sin parametros


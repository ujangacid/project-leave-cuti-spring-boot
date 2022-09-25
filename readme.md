## Leave Request API

Project ini merupakan REST API untuk permintaan cuti sebuah user dengan table people, dimana sebelum
menggunakannya harus login terlebih dahulu lalu pengguna dapat melakukan permintaan leave (cuti) dengan
melihat daftar cuti apa saja yang tersedia pada table leave .

### Technologies

- PostgreSQL
- Java Spring boot

### API Spec

#### people Register

- Request: POST
- Endpoint : `api/people/`
- Header :
  - Content-Type: application/json
  - Accept: application/json
- Body :

```json
{
  "name": "String",
  "address": "String",
  "position": "String",
  "nip": "String"

}
```

Response:

```json
{

        "id": "int",
        "name": "String",
        "address": "String",
        "position": "String",
        "nip": "String",
}
```

#### List People

- Request: GET
- Endpoint : `api/people/`
- Header :
  - Content-Type: application/json
  - Accept: application/json
- Body :

```json
{
  
}
```

Response:

```json
{
    "id":"int",
    "name": "String",
    "address": "String",
    "position": "String",
    "nip": "String"
}
```

#### Get ID People

- Request: GET
- Endpoint : `api/people/id`
- Header :
  - Content-Type: application/json
  - Accept: application/json
- Body :

```json
{
  
}
```

Response:

```json
{
    "id":"int",
    "name": "String",
    "address": "String",
    "position": "String",
    "nip": "String"
}
```
#### EDIT People

- Request: PUT
- Endpoint : `api/people`
- Header :
  - Content-Type: application/json
  - Accept: application/json
- Body :

```json
{
    "name":"String",
    "address":"String",
    "position":"String",
    "nip":"String",
    "id":"int"
}
```

Response:

```json
{
    "id":"int",
    "name": "String",
    "address": "String",
    "position": "String",
    "nip": "String"
}
```

#### Remove people

- Request: DELETE
- Endpoint : `api/people/id`
- Header :
  - Content-Type: application/json
  - Accept: application/json

Body:

```json
{

}
```
Response:

```json
{
  "message: id {id} deleted"
}
```

#### ADD Leave

- Request: POST
- Endpoint : `api/leave`
- Header :
  - Content-Type: application/json
  - Accept: application/json

Body:

```json
{
    "type": "String",
    "cuti": "String"
}
```

Response:

```json
{

  "id": "int",
  "type": "String",
  "cuti": "String"
}
```

#### List Leave

- Request: GET
- Endpoint : `api/leave`
- Header :
  - Content-Type: application/json
  - Accept: application/json

Body:

```json
{

}
```

Response:

```json
{
  "id": "int",
  "type": "String",
  "cuti": "String"
}
```
#### EDIT Leave

- Request: PUT
- Endpoint : `api/leave`
- Header :
  - Content-Type: application/json
  - Accept: application/json

Body:

```json
{
    "type": "String",
    "cuti": "String",
    "id":"int"
}
```
Response:

```json
{

  "id": "int",
  "type": "String",
  "cuti": "String"
}
```

#### Remove leave

- Request: DELETE
- Endpoint : `api/leave/id`
- Header :
  - Content-Type: application/json
  - Accept: application/json

Body:

```json
{

}
```
Response:

```json
{
  "message: id {id} deleted"
}
```
#### ADD Leave-request

- Request: POST
- Endpoint : `api/leave-request`
- Header :
  - Content-Type: application/json
  - Accept: application/json

Body:

```json
{
    "people_id":"int",
    "leave_id":"int",
    "start_date":"DATE",
    "end_date":"DATE",
    "reason":"String"
}
```

Response:

```json
{

  "id": "int",
  "people": {
      "id": "int",
      "name": "String",
      "address": "String",
      "position": "String",
      "nip": "String"
        },
  "leave": {
      "id":"int",
      "type": "String",
      "cuti": "String"
        },
        "startDate": "DATE",
        "endDate": "DATE",
        "reason": "String"
}
```

#### LIST Leave-request

- Request: GET
- Endpoint : `api/leave-request`
- Header :
  - Content-Type: application/json
  - Accept: application/json

Body:

```json
{

}
```
Response:

```json
{

  "id": "int",
  "people": {
      "id": "int",
      "name": "String",
      "address": "String",
      "position": "String",
      "nip": "String"
        },
  "leave": {
      "id":"int",
      "type": "String",
      "cuti": "String"
        },
        "startDate": "DATE",
        "endDate": "DATE",
        "reason": "String"
}
```

#### Remove Leave-request

- Request: GET
- Endpoint : `/leave-request/id`
- Header :
  - Content-Type: application/json
  - Accept: application/json

Body:

```json
{

}
```

Response:

```json
{
  "message: id {id} deleted" 
}
```
# Spec Service API v0.0.1

## Model

   - User
   
    - id (not Null, unique, pk)
    - username
    - password
    - email
    - telephone
    - statusEmployee
    - isActive
    - createdAt
    - modifiedAt
    
   - UserInfo
   
    - id (not Null, unique, pk)
    - userId (pfk)
    - planning
    - location
    - absentMorning ( Int = 1)
    - absentAfternoon ( Int = 1)
    - absentEvening ( Int = 1)
    - isPresent ( if ( absentMorning +  absentAfternoon + absentEvening = 3) )
    - createdAt
    - modifiedAt
    
## API Spec

#### Register

    - Method POST
    - Accept: application/json
    - Content-Type: application/json
    - endpoint: /api/v1/users
    
   - body :
   
```json
{ 
  "username": "string | required",
  "email": "string | required",
  "password": "string | required",
  "telephone": "string | required",
  "statusEmployee": "string | required"
}
```

- response :

```json
{ 
  "apiVersion": "REST-API v0.0.1",
  "statusCode": "201 | 200 | 400 | 401",
  "statusMessage": "Success | Bad Request | Not Found",
  "data": {
    "id": "string",
    "username": "string | required",
    "email": "string | required",
    "password": "string | required",
    "telephone": "string | required",
    "statusEmployee": "string | required",
    "isActive": false,
    "userInfo": [],
    "createdAt": "TimeStamp",
    "modifiedAt": "TimeStamp | null"
  },
  "responseDate": "Timestamp"
}
```

#### Get User

    - Method GET
    - Content-Type: application/json
    - endpoint: /api/v1/users/{userId}
    
- response :

```json
{ 
  "apiVersion": "REST-API v0.0.1",
  "statusCode": "201 | 200 | 400 | 401",
  "statusMessage": "Success | Bad Request | Not Found",
  "data": {
    "id": "string",
    "username": "string | required",
    "email": "string | required",
    "password": "string | required",
    "telephone": "string | required",
    "statusEmployee": "string | required",
    "isActive": false,
    "userInfo": [
      {
        "userId": "string",
        "planning": "string",      
        "location": "string",      
        "absentMorning": "Int",      
        "absentAfternoon": "Int",      
        "absentEvening": "Int",
        "isPresent": "Int",
        "createdAt": "TimeStamp",
        "modifiedAt": "TimeStamp | null"
      }
    ],
    "createdAt": "TimeStamp",
    "modifiedAt": "TimeStamp | null"
  },
  "responseDate": "Timestamp"
}
```

#### Get All User

    - Method GET
    - Content-Type: application/json
    - endpoint: /api/v1/users/
    
- response :

```json
{ 
  "apiVersion": "REST-API v0.0.1",
  "statusCode": "201 | 200 | 400 | 401",
  "statusMessage": "Success | Bad Request | Not Found",
  "data":[ 
    {
    "id": "string",
    "username": "string | required",
    "email": "string | required",
    "password": "string | required",
    "telephone": "string | required",
    "statusEmployee": "string | required",
    "isActive": false,
    "userInfo": [
      {
        "userId": "string",
        "planning": "string",      
        "location": "string",      
        "absentMorning": "Int",      
        "absentAfternoon": "Int",      
        "absentEvening": "Int",
        "isPresent": "Int",
        "createdAt": "TimeStamp",
        "modifiedAt": "TimeStamp | null"
      }
    ],
    "createdAt": "TimeStamp",
    "modifiedAt": "TimeStamp | null"
   },
   {
    "id": "string",
    "username": "string | required",
    "email": "string | required",
    "password": "string | required",
    "telephone": "string | required",
    "statusEmployee": "string | required",
    "isActive": false,
    "userInfo": [
      {
        "userId": "string",
        "planning": "string",      
        "location": "string",      
        "absentMorning": "Int",      
        "absentAfternoon": "Int",      
        "absentEvening": "Int",
        "isPresent": "Int",
        "createdAt": "TimeStamp",
        "modifiedAt": "TimeStamp | null"
      }
    ],
    "createdAt": "TimeStamp",
    "modifiedAt": "TimeStamp | null"
   }
  ],
  "responseDate": "Timestamp"
}
```

#### Update User

    - Method PUT
    - Accept: application/json
    - Content-Type: application/json
    - endpoint: /api/v1/users/{userId}
    
   - body :
   
```json
{ 
  "username": "string | required",
  "email": "string | required",
  "password": "string | required",
  "telephone": "string | required",
  "statusEmployee": "string | required"
}
```

- response :

```json
{ 
  "apiVersion": "REST-API v0.0.1",
  "statusCode": "201 | 200 | 400 | 401",
  "statusMessage": "Success | Bad Request | Not Found",
  "data": {
    "id": "string",
    "username": "string | required",
    "email": "string | required",
    "password": "string | required",
    "telephone": "string | required",
    "statusEmployee": "string | required",
    "isActive": false,
    "userInfo": [
      {
        "userId": "string",
        "planning": "string",      
        "location": "string",      
        "absentMorning": "Int",      
        "absentAfternoon": "Int",      
        "absentEvening": "Int",
        "isPresent": "Int",
        "createdAt": "TimeStamp",
        "modifiedAt": "TimeStamp | null"
      }
    ],
    "createdAt": "TimeStamp",
    "modifiedAt": "TimeStamp | null"
  },
  "responseDate": "Timestamp"
}
```

#### Create Absent

    - Method POST
    - Accept: application/json
    - Content-Type: application/json
    - endpoint: /api/v1/info
    
   - body :
   
```json
{
    "userId": "string",
    "planning": "string",      
    "location": "string",      
    "absentMorning": "Int",      
    "absentAfternoon": "Int",      
    "absentEvening": "Int"
}
```

- response :

```json
{
    "userId": "string",
    "planning": "string",      
    "location": "string",      
    "absentMorning": "Int",      
    "absentAfternoon": "Int",      
    "absentEvening": "Int",
    "isPresent": "Int",
    "createdAt": "TimeStamp",
    "modifiedAt": "null"
}
```

#### Create Absent

    - Method PUT
    - Accept: application/json
    - Content-Type: application/json
    - endpoint: /api/v1/info/{userId}
    
   - body :
   
```json
{
    "userId": "string",
    "planning": "string",      
    "location": "string",      
    "absentMorning": "Int",      
    "absentAfternoon": "Int",      
    "absentEvening": "Int"
}
```

- response :

```json
{
    "userId": "string",
    "planning": "string",      
    "location": "string",      
    "absentMorning": "Int",      
    "absentAfternoon": "Int",      
    "absentEvening": "Int",
    "isPresent": "Int",
    "createdAt": "TimeStamp",
    "modifiedAt": "TimeStamp"
}
```
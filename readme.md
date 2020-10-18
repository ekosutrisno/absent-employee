# Spec Service API v0.0.1

## Model

   - Employee
   
    - employeeId (not Null, unique, pk)
    - fullName
    - password
    - email
    - telephone
    - statusEmployee
    - isActive
    - createdAt
    - modifiedAt
    
   - EmployeeInfo
   
    - employeeInfoId (not Null, unique, pk)
    - employeeId (pfk)
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
    - endpoint: /api/v1/employees
    
   - body :
   
```json
{ 
  "fullName": "string | required",
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
    "fullName": "string | required",
    "email": "string | required",
    "password": "string | required",
    "telephone": "string | required",
    "statusEmployee": "string | required",
    "isActive": false,
    "employeeInfo": [],
    "createdAt": "TimeStamp",
    "modifiedAt": "TimeStamp | null"
  },
  "responseDate": "Timestamp"
}
```

#### Get Employee

    - Method GET
    - Content-Type: application/json
    - endpoint: /api/v1/employees/{employeeId}
    
- response :

```json
{ 
  "apiVersion": "REST-API v0.0.1",
  "statusCode": "201 | 200 | 400 | 401",
  "statusMessage": "Success | Bad Request | Not Found",
  "data": {
    "id": "string",
    "fullName": "string | required",
    "email": "string | required",
    "password": "string | required",
    "telephone": "string | required",
    "statusEmployee": "string | required",
    "isActive": false,
    "employeeInfo": [
      {
        "employeeId": "string",
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

#### Get All Employee

    - Method GET
    - Content-Type: application/json
    - endpoint: /api/v1/employees
    
- response :

```json
{ 
  "apiVersion": "REST-API v0.0.1",
  "statusCode": "201 | 200 | 400 | 401",
  "statusMessage": "Success | Bad Request | Not Found",
  "data":[ 
    {
    "id": "string",
    "fullName": "string | required",
    "email": "string | required",
    "password": "string | required",
    "telephone": "string | required",
    "statusEmployee": "string | required",
    "isActive": false,
    "employeeInfo": [
      {
        "employeeId": "string",
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
    "fullName": "string | required",
    "email": "string | required",
    "password": "string | required",
    "telephone": "string | required",
    "statusEmployee": "string | required",
    "isActive": false,
    "employeeInfo": [
      {
        "employeeId": "string",
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

#### Update Employee

    - Method PUT
    - Accept: application/json
    - Content-Type: application/json
    - endpoint: /api/v1/employees/{employeeId}
    
   - body :
   
```json
{ 
  "fullName": "string | required",
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
    "fullName": "string | required",
    "email": "string | required",
    "password": "string | required",
    "telephone": "string | required",
    "statusEmployee": "string | required",
    "isActive": false,
    "employeeInfo": [
      {
        "employeeId": "string",
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
    "employeeId": "string",
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
    "employeeId": "string",
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

#### Update Absent

    - Method PUT
    - Accept: application/json
    - Content-Type: application/json
    - endpoint: /api/v1/info/{employeeId}
    
   - body :
   
```json
{
    "employeeId": "string",
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
    "employeeId": "string",
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
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
    - modifedAt
    
   - UserInfo
   
    - id (not Null, unique, pk)
    - userId (pfk)
    - planning
    - location
    - absentMorning ( Int = 1)
    - absentAfternoon ( Int = 1)
    - absentEvening ( Int = 1)
    - isPresent ( if ( absentMorning +  absentAfternoon + absentEvening = 3) )
    
## API Spec

- Register
    - Method POST
    - Accept : application/json
    - Content-Type: application/json
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
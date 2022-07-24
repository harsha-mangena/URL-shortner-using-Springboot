

# URL-shortner-using-springboot
This is a simple url shortening service built with Spring boot and Rest API's.

## API End Points
### - /v1/register
      - Request Parameter String [LongUrl]
### - /v1/register-custom
      - Request Parameter String[LongUrl]
      - Request Parameter String[CustomUrl]
      
## Database
### H2 - In Memory Database
    * Schema  - String shortUrl(Primary Key | Index)
              - String longUrl(Index)
              - String createdAt
              

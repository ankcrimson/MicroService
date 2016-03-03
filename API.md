FORMAT: 1A
HOST: http://polls.apiblueprint.org/

# MicroService

A token creation and retrival MicroService

## Tokens Listing [/tokens]

### List All Tokens [GET]

+ Response 200 (application/json)

        [
            {
                "version": "v1",
                "tokens": [
                    {
                        "user": "John",
                        "toeknHash": 2048
                    }, {
                        "user": "Jack",
                        "toeknHash": 1024
                    }, {
                        "user": "Ankur",
                        "toeknHash": 512
                    }, {
                        "user": "Stephen",
                        "toeknHash": 256
                    }
                ]
            }
        ]

## Tokens Creation [/createToken]

### Create a New Token [POST]

Create new token based on the json request.

+ Request (application/json)

        {
            "user": "Timon"
        }

+ Response 201 (application/json)

    + Headers

            Location: /createToken

    + Body

            {
                "creation": "success",
                "hash":"hashed value"
            }

## About Service [/about]

### About Service [GET]

+ Response 200 (application/json)

        [
            {
                "name" : "MicroService",
                "version" : "v1"
                
            }
        ]


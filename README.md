#Lead Collector
#### com segurança

----------------

## Rotas

#### Cadastro:
- /usuario
- POST
- json
````json
{
  "email":"xablau@zup.com",
  "senha":"Aviao11"
}
````
- Resposta 201
-------
#### Atualizar Cadastro
- /usuario
- PUT
- Precisa de Token de Autenticação
- json
````json
{
  "email":"xablau@zup.com",
  "senha":"Aviao11"
}
````
- Resposta 200
----------

#### Login
- /login
- PUT
- json
````json
{
  "email":"xablau@zup.com",
  "senha":"Aviao11"
}
````
- Resposta 200
````json
{
  "Authorization":"Token 1278637gdasdas"
}
````

------

#### Cadastro Lead
- /leads
- POST
- json
````json
{
  "nome":"Marvin",
  "email":"marvin@dontpanic.com",
  "observacoes":"Não gosta de nada"
}
````
- Resposta 201
````json
{
  "nome":"Marvin",
  "email":"marvin@dontpanic.com",
  "observacoes":"Não gosta de nada"
}
````
--------

#### Ataualizar Lead
- /leads
- PUT
- Precisa de Token de Autenticação
- json
````json
{
  "nome":"Marvin",
  "email":"marvin@don'tpanic.com",
  "observacoes":"Não gosta de nada"
}
````
- Resposta 200
````json
{
  "nome":"Marvin",
  "email":"marvin@don'tpanic.com",
  "observacoes":"Não gosta de nada"
}
````

-------
#### Visualizar Leads
- /leads
- GET
- Precisa de Token de Autenticação
- Resposta 200
````json
[
  {
    "nome":"Marvin",
    "email":"marvin@don'tpanic.com",
    "observacoes":"Não gosta de nada"
  }
]
````

-------
#### Deletar Leads
- /leads/{email}
- DELETE
- Precisa de Token de Autenticação
- Resposta 204

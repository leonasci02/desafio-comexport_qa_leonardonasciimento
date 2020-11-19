#language: pt
@Api
Funcionalidade: Consultar estudante
  Como um usuário técnico, devo realizar a operação do tipo get para obter as informações 
  referente aos estudantes.

  Cenário: Consultar todos os estudante
    Dado que acesse a url do swagger
    Quando optar por selecionar a operação do tipo get
    Então o sistema deve retornar o status code 200 com a lista de estudante

  Cenário: Consultar apenas um estudante
    Dado que acesse a url do swagger
    Quando optar por informar o cpf do estudante com a operação do tipo get
    Então o sistema deve retornar o status code 200 com as informações do estudante

  Cenário: Consultar estudante com um livro
    Dado que acesse a url do swagger
    Quando optar por informar o cpf do estudante com a operação do tipo get
    Então o sistema deve retornar o status code 200 com as informações do estudante
    E o livros selecionados

  Cenário: Consultar um estudante com cpf inválido
    Dado que acesse a url do swagger
    Quando optar por informar o cpf inválido do estudante com a operação do tipo get
    Então o sistema deve retornar o status code 500
    
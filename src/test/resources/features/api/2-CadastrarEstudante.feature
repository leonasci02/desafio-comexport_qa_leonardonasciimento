#language: pt
@Api
Funcionalidade: Cadastrar estudante
  Como um usuário técnico, devo realizar a operação do tipo post para cadastrar 
  um novo estudante com um vinculo de livros.

  Cenário: Cadastrar estudante
    Dado que acesse a url do swagger
    Quando optar por preencher os dados do estudante com livros
    Então o sistema deve retornar o status code 201 com a mensagem de sucesso

  Cenário: Cadastrar estudante com dados inválido
    Dado que acesse a url do swagger
    Quando optar por preencher dados inválido de um estudante com livros
    Então o sistema deve retornar o status code 400 com a mensagem de erro

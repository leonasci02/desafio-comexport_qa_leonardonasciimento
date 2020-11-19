#language: pt
@Api
Funcionalidade: Atualizar dados estudante
  Como um usuário técnico, devo realizar a operação do tipo patch para atualizar 
  as informações de nome e e-mail dos estudantes.

@Api1
  Cenário: Atualizar um estudante
    Dado que acesse a url do swagger
    Quando optar por atualizar os dados obrigatórios na operação do tipo patch
    Então o sistema deve retornar o status code 200 com a mensagem de atualizacao

  Cenário: Atualizar sem informar os dados obrigatórios
    Dado que acesse a url do swagger
    Quando optar por não informar os dados obrigatórios na operação do tipo patch
    Então o sistema não deve atualizar o estudante e apresentar o status code 400
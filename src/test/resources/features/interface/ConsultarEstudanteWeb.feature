#language: pt
@Web
Funcionalidade: Consultar estudante web
  Como um usuário gostaria de acessar o sistema e realizar a consulta de um estudante

  Cenário: Consultar todos os estudantes
    Dado que acesse o sistema de estudante
    Quando optar por selecionar a opcao student getAll
    E selecionar a opcao try it out
    Então o sistema apresenta a aba de response com a lista de estudantes

  Cenário: Consultar apenas um estudante
    Dado que acesse o sistema de estudante
    Quando optar por selecionar a opcao student get
    E selecionar a opcao try it out
    E opto por preencher o cpf
    Então o sistema apresenta a aba de response com estudante especifico

  Cenário: Consultar estudante com cpf inválido
    Dado que acesse o sistema de estudante
    Quando optar por selecionar a opcao student get
    E selecionar a opcao try it out
    E opto por preencher o cpf inválido
    Então o sistema apresenta a aba de response com mensagem de erro
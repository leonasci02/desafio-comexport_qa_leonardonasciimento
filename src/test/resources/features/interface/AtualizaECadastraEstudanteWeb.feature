#language: pt
@Web
Funcionalidade: Atualizazr e cadastrar estudante web

  Cenário: Cadastrar estudante inválido
    Dado que acesse o sistema de estudante
    Quando optar por selecionar a opcao student post
    E selecionar a opcao try it out
    E opto por preencher os dados de inclusão
    Então o sistema apresenta a aba de response com erro no cadastro

  Cenário: Atualizar estudante inválido
    Dado que acesse o sistema de estudante
    Quando optar por selecionar a opcao student patch
    E selecionar a opcao try it out
    E opto por preencher cpf e dados de alteracao
    Então o sistema apresenta a aba de response com erro na atualização
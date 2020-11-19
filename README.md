# **Desafio Comexport **

Realizado o desafio de automação de testes para a empresa Comexport. 

# Bibliotecas utilizadas:

- webdrivermanager
- selenium
- cucumber
- junit
- maven
- javafaker
- unirest
- log4j

### Pré-Condição de execução

1. Acessar o link do repositório do desafio: https://github.com/comexport/qa_engineer_test.git
2. Criar uma pasta local em sua máquina
3. Abrir o prompt de comando e digitar a seguinte instrução: 
     - git clone https://github.com/comexport/qa_engineer_test.git
4. Ainda no prompt, ir até a pasta criada, exemplo:
    - cd qa_engineer_test
5. Na raiz do projeto baixado, deve ser digitado a seguinte instrução:
    - mvn clean install
6. Após a conclusão, devemos subir o servidor do spring-boot:
    - mvn spring-boot:run

#### OBS: A máquina deve possuir a configuração do java path e maven home

### Configuração para execução dos testes automatizados

1. Acessar o link dos testes automatizados: https://github.com/leonasci02/desafio-comexport_qa_leonardonasciimento.git
2. Criar uma pasta local em sua máquina
3. Abrir o prompt de comando e digitar a seguinte instrução: 
     - git clone https://github.com/leonasci02/desafio-comexport_qa_leonardonasciimento.git
4. Ainda no prompt, ir até a pasta criada, exemplo:
    - cd desafio-comexport_qa_leonardonasciimento
5. Na raiz do projeto baixado, deve ser digitado a seguinte instrução:
    - mvn install -Dmaven.test.skip=true
    
### Executar os testes automatizados

Para executar os testes automatizados de API e Web devemos seguir os passos abaixos:

#### API: 

1. Executar o comando via prompt: mvn test -Dcucumber.options=" --tags @Api"

#### Web: 

1. Executar o comando via prompt: mvn test -Dcucumber.options=" --tags @Web"

### Pipeline

Na raiz do projeto, existe o arquivo JenkinsFile com todos os parametros necessário para uma execução via jenkins

- Configurar o global tools, para refletir as variaveis de ambiente do java e maven
- Cria um novo JOB Item
- Criar o novo JOB como pipeline
- Ir até a aba de pipeline selecionar a definição "Pipeline script from SCM"
- Selecionar a opção Git no campo SCM
- Informar a url do projeto https://github.com/leonasci02/desafio-comexport_qa_leonardonasciimento.git
- Deixar como a branch "Master"
- Salvar a pipeline

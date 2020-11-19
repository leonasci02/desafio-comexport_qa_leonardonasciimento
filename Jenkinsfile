pipeline{
    agent any
        stages{
            stage('Ckeckout Git Comexport'){
                steps{
                    git 'https://github.com/comexport/qa_engineer_test.git'
                }
            }
            stage('Instalando dependencias do projeto Comexport'){
                steps{
                    bat 'mvn clean install'
                }
            }
            stage('Deploy Comexport'){
                steps{
                    bat 'mvn spring-boot:run'
                }
            }
            stage('Test Api Desafio'){
                steps{
                   dir('Api'){
                       git 'https://github.com/leonasci02/desafio-comexport_qa_leonardonasciimento.git'
                       bat 'mvn install -Dmaven.test.skip=true'
                       bat "mvn test -Dcucumber.options=\" --tags @Api\""
                   }
                }
            }
            stage('Test Web Desafio'){
                steps{
                   dir('Web'){
                       git 'https://github.com/leonasci02/desafio-comexport_qa_leonardonasciimento.git'
                       bat 'mvn install -Dmaven.test.skip=true'
                       bat "mvn test -Dcucumber.options=\" --tags @Web\""
                   }
                }
            }
        }
    post{
        always{
            junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
        }
    }
}
pipeline {
  agent any
  stages {
    stage('Limpiando y compilando') {
      parallel {
        stage('Limpiando y compilando') {
          steps {
            sh 'chmod +x mvnw'
            sh './mvnw clean'
            sh './mvnw compile'
            sh './mvnw package'
            sh 'ls'
          }
        }

        stage('Creando docker') {
          steps {
            echo 'Iniciando compilacion de imagen de Docker'
            dir(path: '/var/jenkins_home/workspace/maestros_main/target') {
              script {
                def dockerImage=docker.build("maestros:00")
              }

            }

          }
        }

      }
    }

  }
  environment {
    Usuario = '000'
    Clave = '000'
  }
}
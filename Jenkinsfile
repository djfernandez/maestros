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
          }
        }

        stage('Creando docker') {
          steps {
            echo 'Iniciando compilacion de imagen de Docker'
            script {
              def dockerImage=docker.build("maestros:00")
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
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
            sh 'pwd'
            sh 'docker build -t maestros:01 .'
          }
        }

        stage('Creando docker') {
          steps {
            echo 'Iniciando compilacion de imagen de Docker'
            sh 'docker build -t maestros:01 .'
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
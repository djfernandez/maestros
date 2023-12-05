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
          }
        }

        stage('Creando docker') {
          steps {
            echo 'Ruta actual'
            sh 'pwd'
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
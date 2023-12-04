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
            echo 'Iniciando compilacion de imagen de Docker'
            sh 'docker build -f Dockerfile -t fuentes /var/jenkins_home/workspace/maestros_main'
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
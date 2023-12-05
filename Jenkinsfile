pipeline {
  agent any
  stages {
    stage('Limpiando y compilando') {
      steps {
        sh 'chmod +x mvnw'
        sh './mvnw clean'
        sh './mvnw compile'
        sh './mvnw package'
        sh 'docker build -t maestros:01 .'
      }
    }
  }
  environment {
    Usuario = '000'
    Clave = '000'
  }
}
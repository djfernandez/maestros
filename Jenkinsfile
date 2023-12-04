pipeline {
  agent any
  stages {
    stage('Limpiar proyecto') {
      steps {
        sh './mvnw clean'
        sh './mvnw compile'
        sh './mvnw package'
      }
    }

  }
  environment {
    Usuario = '000'
    Clave = '000'
  }
}
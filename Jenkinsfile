pipeline {
  agent any
  stages {
    stage('stage1') {
      steps {
        echo 'hello stage1'
      }
    }
    stage('stage 2') {
      steps {
        catchError() {
          error 'some error occured'
        }

      }
    }
  }
}
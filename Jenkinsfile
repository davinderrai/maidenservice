pipeline {
  agent {
    node {
      label 'master'
    }

  }
  stages {
    stage('Build') {
      steps {
        echo 'Build from github'
        git(url: 'https://github.com/davinderrai/maidenservice.git', branch: 'master', changelog: true, credentialsId: 'davinderrai')
        node(label: 'alpha')
      }
    }
    stage('Test') {
      parallel {
        stage('Unit Test') {
          steps {
            echo 'Run Unit Test'
          }
        }
        stage('Static Code Analysis') {
          steps {
            echo 'Do Code Analysis through SonarCube'
          }
        }
      }
    }
    stage('Acceptance') {
      steps {
        echo 'Do Acceptance testing using Postman/Newman'
      }
    }
    stage('Register') {
      steps {
        echo 'Register Image'
      }
    }
    stage('Deploy') {
      steps {
        echo 'Deploy on Swarm'
      }
    }
  }
}
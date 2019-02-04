pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Build Phase Started :: Fetching code from Github :: ...'
        git(url: 'https://github.com/davinderrai/maidenservice.git', branch: 'devops', changelog: true, credentialsId: 'davinderrai')
        echo 'Build Phase :: Compile Code :: ...'
        sh 'mvn compile'
        echo 'Build Phase :: Package :: ...'
        sh 'mvn clean package -DskipTests'
      }
    }
    stage('Test') {
      parallel {
        stage('Unit Test') {
          steps {
            echo 'Test Phase Started :: Unit Test Code :: ...'
            sh 'mvn test'
            echo 'Test Phase :: Integration Testing :: ...'
          }
        }
        stage('Static Code Analysis') {
          steps {
            echo 'Test Phase :: Code Analysis :: ...'
          }
        }
      }
    }
    stage('Acceptance') {
      parallel {
        stage('API Test') {
          steps {
            echo 'Aceeptance Phase Started :: API Test :: ...'
          }
        }
        stage('UI Test') {
          steps {
            echo 'Acceptance Phase Started :: UI Test :: ...'
          }
        }
      }
    }
    stage('Register') {
      steps {
        echo 'Register Phase Started :: Build docker image :: ...'
        sh 'mvn clean docker:build'
        echo 'Register Phase :: Push docker image :: ...'
        sh 'mvn deploy -DpushImageTag -DdockerImageTags=latest,1.0'
      }
    }
    stage('Deploy') {
      steps {
        echo 'Deploy Phase Started :: Deploy Service on Swarm :: ...'
      }
    }
  }
}
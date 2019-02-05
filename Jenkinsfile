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
    stage('Register') {
      steps {
        echo 'Register Phase Started :: Build docker image :: ...'
        sh 'mvn clean docker:build -DpushImageTag -DdockerImageTags=latest,1.0'
        echo 'Register Phase :: Push docker image :: ...'
      }
    }
    stage('Stage') {
      steps {
        echo 'Deploy Phase Started :: Deploy Service on Swarm :: ...'
      }
    }
    stage('Acceptance') {
      parallel {
        stage('API Test') {
          steps {
            echo 'Acceptance Phase Started :: API Test :: ...'
          }
        }
        stage('UI Test') {
          steps {
            echo 'Acceptance Phase Started :: UI Test :: ...'
          }
        }
      }
    }
    stage('Promote') {
      steps {
        echo 'Promote Code Branch'
      }
    }
  }
}
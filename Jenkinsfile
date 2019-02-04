pipeline {
  agent any
  stages {
    stage('Initialize') {
      steps {
        echo 'Hello Jenkins world'
        slackSend(channel: 'dealroombuild', color: 'red', failOnError: true, message: 'Demo msg', teamDomain: 'dealroom2.slack.com', tokenCredentialId: 'SlackToken')
      }
    }
  }
}
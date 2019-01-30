pipeline {
    agent none
    stages {
        stage('run-parallel-branches') {
          steps {
            parallel(
              a: {
                echo "This is branch a"
              },
              b: {
                echo "This is branch b"
              }
            )
          }
        }
        stage('deploy') {
          steps {
            parallel(
              a: {
                echo "This is branch a"
              },
              b: {
                echo "This is branch b"
              },
              c: {
                echo "This is branch c"
              }
            )
          }
        }
    }
}

pipeline {
    agent any

    environment {
        MAX_SIZE = '100'
        MIN_SIZE = '10'
    }

    stages {
        stage('global') {
            steps {
                echo "MAX_SIZE: ${env.MAX_SIZE}"
                echo "MIN_SIZE: ${env.MIN_SIZE}"
            }
        }

        stage('local') {
            environment {
                MAX_SIZE = '200'
                MIN_SIZE = '20'
            }

            steps {
                echo "MAX_SIZE: ${env.MAX_SIZE}"
                echo "MIN_SIZE: ${env.MIN_SIZE}"
            }
        }
    }
}
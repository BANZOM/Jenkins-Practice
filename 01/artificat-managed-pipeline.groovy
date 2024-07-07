pipeline {
    agent any

    stages {
        stage('build') {
            steps {
                sh "echo 'Hello World' > sample.txt"
                sh "echo 'Main' > main.txt"
            }
        }
        stage('archive') {
            steps {
                archiveArtifacts allowEmptyArchive: true, artifacts: '*.txt', excludes: 'main.txt', fingerprint: true, followSymlinks: false, onlyIfSuccessful: true
            }
        }
    }
}

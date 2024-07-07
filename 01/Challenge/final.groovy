pipeline {
    agent any

    parameters {
        choice(name: 'ENVIRONMENT',
            choices: ['DEVELOPMENT' , 'STAGING', 'PRODUCTION'],
            description: 'Choose the environment for this deployment')

        password(name: 'APIKEY',
            defaultValue: '123ABC',
            description: 'Enter the API key')
        
        text(name: 'CHANGELOG',
            description: 'Enter the change log',
            defaultValue: 'This is the change log.')
    }

    stages {
        stage('Test') {
            steps {
                echo "This step tests the project"
            }
        }
        stage('Deploy') {

            when {
                expression { params.ENVIRONMENT == 'PRODUCTION' }
            }
            steps {
                echo "This stage deploys the project"
            }
        }
        stage('Report') {
            steps {
                echo "This stage generates a report"
                sh "echo '${params.CHANGELOG}' > ${params.ENVIRONMENT.toLowerCase()}.txt"
                archiveArtifacts allowEmptyArchive: true, 
                    artifacts: '*.txt', 
                    fingerprint: true, 
                    followSymlinks: false, 
                    onlyIfSuccessful: true
            }
        }
    }
}
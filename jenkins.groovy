pipeline {
    agent any
    
    environment {
        DIRECTORY_PATH = "/path/to/code"
        TESTING_ENVIRONMENT = "testing_environment"
        PRODUCTION_ENVIRONMENT = "YourName" // Replace YourName with your actual name
    }
    
    stages {
        stage('Build') {
            steps {
                echo "Fetch the source code from the directory path specified by the environment variable: ${env.DIRECTORY_PATH}"
                echo "Compile the code and generate any necessary artifacts"
            }
        }
        
        stage('Test') {
            steps {
                echo "Run unit tests"
                echo "Run integration tests"
            }
        }
        
        stage('Code Quality Check') {
            steps {
                echo "Check the quality of the code"
            }
        }
        
        stage('Deploy') {
            steps {
                echo "Deploy the application to a testing environment specified by the environment variable: ${env.TESTING_ENVIRONMENT}"
            }
        }
        
        stage('Approval') {
            steps {
                script {
                    echo "Waiting for manual approval..."
                    sleep time: 10, unit: 'SECONDS'
                }
            }
        }
        
        stage('Deploy to Production') {
            steps {
                echo "Deploy the code to the production environment ${env.PRODUCTION_ENVIRONMENT}"
            }
        }
    }
}

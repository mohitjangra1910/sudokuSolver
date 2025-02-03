pipeline {
    agent any

    // Trigger the build when a push event occurs
    triggers {
        githubPush()
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the repository
                checkout scm
            }
        }
        stage('Build') {
            steps {
                sh 'javac -d out src/SudokuSolver.java'
            }
        }
        stage('Test') {
            steps {
                // Run the built jar using the sample_input file.
                // Adjust the jar file name if necessary.
                sh 'sudo java -cp out SudokuSolver < sample_input'

            }
        }
    }

    post {
        success {
            echo 'Build and test succeeded!'
        }
        failure {
            echo 'Build or test failed.'
        }
    }
}

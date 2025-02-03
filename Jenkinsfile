pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Pull the latest code from GitHub
                git url: 'https://github.com/yourusername/sudoku-solver.git', branch: 'main'
            }
        }
        
        stage('Build') {
            steps {
                // Clean and compile the project using Maven
                sh 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                // Run the unit tests; if you have JUnit tests, this will run them
                sh 'mvn test'
            }
        }
        
        stage('Run (Simulated Input)') {
            steps {
                // Since your program expects user input, simulate it by piping input.
                // Replace "sample_input" with the actual input your program expects.
                // Replace 'your.package.Main' with your actual main class path.
                sh 'echo "sample_input" | java -cp target/classes SudokuSolver'
            }
        }
    }
    
    post {
        success {
            echo 'Build, Test, and Run stages completed successfully!'
        }
        failure {
            echo 'One or more stages failed.'
        }
    }
}

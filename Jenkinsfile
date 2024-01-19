pipeline {
	agent any

	environment {
		mavenHome = tool 'jenkins-maven'
	}
	stages {
	
		stage('clean'){
			steps {
				sh "mvn clean -DskipTests"
			}
		}
		stage('Compile'){
			steps {
				sh "mvn compile -DskipTests"
			}
		}
		stage('Test'){
			steps{
				sh 'echo "testing"'
			}
		}
		stage('Build'){
			steps {
				sh "mvn install -DskipTests"
			}
		}
		stage('Dockerize'){
			steps{
				sh "docker build -t exam ."
			}
		}
		
	}
}
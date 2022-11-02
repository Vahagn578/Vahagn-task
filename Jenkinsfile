pipeline {
	agent any
	stages {
		stage ('Compile Stage') {
			steps {
				script {
                    sh 'mvn clean compile'
				}
			}
		}

		stage ('Testing Stage') {
			steps {
				script {
                    sh 'mvn test'
				}
			}
		}
	}
}
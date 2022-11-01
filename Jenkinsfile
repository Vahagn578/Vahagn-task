pipeline {
	agent any
	stages {
		stage ('Compile Stage') {
			steps {
				script {
                    sh '''
                    cd code/Vahagn-task
                    mvn clean compile
                    '''
				}
			}
		}

        stage ('Deployment Stage') {
			steps {
				script {
                    sh '''
                    cd code/Vahagn-task
                    mvn install deploy'''
				}
			}
		}

		stage ('Testing Stage') {
			steps {
				script {
                    sh '''
                    cd code/Vahagn-task
                    mvn test'''
				}
			}
		}
	}
}
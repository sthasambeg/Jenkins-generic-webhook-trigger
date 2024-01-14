pipeline {
    agent any

    triggers {
        GenericTrigger(
            causeString: 'Triggered on $ref',
            token: 'abc123',
            printContributedVariables: true,
            printPostContent: true,
            silentResponse: false,
            shouldNotFlatten: false,
        )
    }

    stages {
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
    }
}

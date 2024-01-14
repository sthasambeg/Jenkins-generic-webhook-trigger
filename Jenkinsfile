pipeline {
    agent any

    triggers {
        GenericTrigger(
            causeString: 'Triggered on $ref',
            token: 'test123',
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
                def payloadMap = readJSON text: payload
                echo "Payload: ${payloadMap}"
            }
        }
    }
}

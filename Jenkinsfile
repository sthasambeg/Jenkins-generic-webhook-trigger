pipeline {
    agent any

    triggers {
        GenericTrigger(
            genericVariables: [
                [key: 'ref', value: '$.ref'],
                [key: 'payload', value: '$']
            ],
            causeString: 'Triggered on $ref',
            token: 'test123',
            printContributedVariables: true,
            printPostContent: true,
            silentResponse: false,
            shouldNotFlatten: false,
        )
    }

    options {
        disableConcurrentBuilds()
    }

    stages {
        stage('Test') {
            steps {
                echo 'Testing..'
                echo "Payload: ${payload}"
                echo 'something new'
            }
        }
    }
}

pipeline {
    agent any

    environment {
        HOOK_TOKEN = 'test123'
    }

    triggers {
        GenericTrigger(
            genericVariables: [
                [key: 'ref', value: '$.ref'],
                [key: 'payload', value: '$']
            ],
            causeString: 'Triggered on $ref',
            token: "$HOOK_TOKEN",
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
                echo "Payload: ${payload}"
            }
        }
    }
}

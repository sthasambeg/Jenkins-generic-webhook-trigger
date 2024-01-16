pipeline {
    agent any

    triggers {
        GenericTrigger(
            genericVariables: [
                [key: 'ref', value: '$.ref'],
                [key: 'payload', value: '$'],
                [key: 'pusher', value: '$.pusher.name'],
                [key: 'head_commit', value: '$.head_commit']
            ],
            causeString: "Triggered on $ref",
            token: 'test123',
            printContributedVariables: false,
            printPostContent: true,
            silentResponse: false,
            shouldNotFlatten: false,
            // filtering when to trigger
            regexpFilterText: '$ref', // ref is used for value used for comparison
            regexpFilterExpression: '^(refs/heads/master)$', // regex for filtering
        )
    }

    options {
        disableConcurrentBuilds()
    }

    stages {
        stage('Test') {
            steps {
                echo 'Testing..'
                // echo "Payload: ${payload}"
                echo 'something new'

                script {
                    println currentBuild.getBuildCauses()
                    if (env.HELLO) {
                        println true
                    } else {
                        println false
                    }
                }
            }
        }
    }
}

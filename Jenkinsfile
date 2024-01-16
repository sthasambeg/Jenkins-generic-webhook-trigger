def scripts

pipeline {
    agent any

    triggers {
        GenericTrigger(
            genericVariables: [
                [key: 'ref', value: '$.ref'],
                [key: 'payload', value: '$'],
                [key: 'pusher', value: '$.pusher.name'],
                [key: 'head_commit', value: '$.head_commit'],
                [key: 'repository', value: '$.repository.full_name'],
            ],
            causeString: "Triggered on push to branch master/main of $repository",
            token: 'test123',
            printContributedVariables: false,
            printPostContent: true,
            silentResponse: false,
            shouldNotFlatten: false,
            // filtering when to trigger
            regexpFilterText: '$ref', // ref is used for value used for comparison
            regexpFilterExpression: '^refs/heads/(master|main)$', // regex for filtering
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
                    if (payload) {
                        echo "Payload: ${payload}"
                    }

                    scripts = load 'scripts.groovy'
                    println currentBuild.getBuildCauses()
                    if (env.HELLO) {
                        println true
                    } else {
                        println false
                    }

                    print scripts.checkCausedByGenericWebhookTrigger()
                }
            }
        }
    }
}

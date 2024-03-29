def scripts

pipeline {
    agent any

    environment {
        DISCORD_WEBHOOK_URL = credentials('konnectcraft-discord-webhook-url')
    }

    triggers {
        GenericTrigger(
            genericVariables: [
                [key: 'ref', value: '$.ref'],
                [key: 'payload', value: '$'],
                [key: 'pusher', value: '$.pusher.name'],
                [key: 'head_commit', value: '$.head_commit'],
                [key: 'repository', value: '$.repository.full_name']
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
                echo 'something new'

                script {
                    try {
                        if (payload) {
                            echo "Payload: ${payload}"
                            def payloadParsed = readJSON text: payload
                            println payloadParsed.repository.full_name
                        }
                    } catch (Exception e) {
                        echo "Error: ${e}"
                    }

                    scripts = load 'scripts.groovy'
                    println currentBuild.getBuildCauses()
                    if (env.HELLO) {
                        println true
                    } else {
                        println false
                    }

                    def triggerInfo = ''
                    if (scripts.checkCausedByGenericWebhookTrigger()) {
                        parsedPayload = readJSON text: payload
                        triggerInfo += """Triggered by Generic Webhook Trigger
                            \n- **trigger repo**: ${parsedPayload.repository.full_name}\n- **trigger branch**: ${parsedPayload.ref}\n- **pusher**: ${parsedPayload.pusher.name}\n- **head commit**: ${parsedPayload.head_commit.id}\n- **head commit message**: ${parsedPayload.head_commit.message}"""
                    }
                    println triggerInfo

                    def discordDescription = "New test running at ${env.BUILD_URL}" + triggerInfo
                    if (env.DISCORD_WEBHOOK_URL != null && env.DISCORD_WEBHOOK_URL != '') {
                        discordSend webhookURL: env.DISCORD_WEBHOOK_URL,
                            title: 'Testing webhook triggered messaging',
                            link: env.BUILD_URL,
                            description: discordDescription,
                            footer: 'Please ignore this message'
                    }
                }
            }
        }
    }
}

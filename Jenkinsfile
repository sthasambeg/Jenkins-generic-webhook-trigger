pipeline {
    agent any

    // triggers {
    //     GenericTrigger(
    //         genericVariables: [
    //             [key: 'ref', value: '$.ref'],
    //             [key: 'payload', value: '$']
    //         ],
    //         causeString: 'Triggered on $ref',
    //         token: 'test123',
    //         printContributedVariables: true,
    //         printPostContent: true,
    //         silentResponse: false,
    //         shouldNotFlatten: false,
    //     )
    // }

    options {
        pipelineTriggers([
            [$class: 'GenericTrigger',
                genericVariables: [
                    [key: 'ref', value: '$.ref'],
                    [
                    key: 'payload',
                    value: '$.before',
                    expressionType: 'JSONPath', //Optional, defaults to JSONPath
                    ]
                ],
                // genericRequestVariables: [
                //  [key: 'requestWithNumber', regexpFilter: '[^0-9]'],
                //  [key: 'requestWithString', regexpFilter: '']
                // ],
                // genericHeaderVariables: [
                //  [key: 'headerWithNumber', regexpFilter: '[^0-9]'],
                //  [key: 'headerWithString', regexpFilter: '']
                // ],

                causeString: 'Triggered on $ref',

                token: 'test123',
                tokenCredentialId: '',

                printContributedVariables: true,
                printPostContent: true,

                silentResponse: false,

                shouldNotFlatten: false,

                // regexpFilterText: '$ref',
                // regexpFilterExpression: 'refs/heads/' + BRANCH_NAME
            ]
        ])
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

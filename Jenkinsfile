
pipeline {
    agent any
    parameters{
        booleanParam(name: 'RC',defaultValue: false, description: 'Is this Release candidate?')
    }
    environment{
        RELEASE='1.0'
    }
    stages{
        stage('BUILD'){
            agent any
            environment{
                LOG_LEVEL = 'INFO'
            }
            steps{
                echo "RELEASE - ${RELEASE}, LOG_LEVEL - ${LOG_LEVEL}"
            }
        }
        stage('TEST'){
            steps{
                 echo "RELEASE - ${RELEASE}..."
                 writeFile file: 'test-result.txt', text: 'TEST RESULT'
            }
        }
        stage('PARALLEL TEST'){
            parallel{
                stage('JAVA TEST'){
                    steps{
                        echo 'Java Test ...'
                    }
                }
                stage('JS TEST'){
                    steps{
                        echo 'JS Test ...'
                    }
                }
                stage('KARMA TEST'){
                    steps{
                        echo 'Karma Test ...'
                    }
                }
            }
        }
        stage('DEPLOY'){
            steps{
                echo "Deploying release ${RELEASE} to environment"
            }
        }
        stage('Publish'){
            when {
                expression { return params.RC }
            }
            steps{
                echo 'Ran after successful confirmation!!!'
            }
        }
    }
    post{
        always{
            echo 'Prints whether deploy happened or not, success or failure'
        }
        success{
            echo 'Inside Post success'
            archiveArtifacts 'test-result.txt'
            notify('Success!!!')
        }
        failure{
            echo 'Inside Post failure'
            notify('failure!!!')
        }
    }
}

void notify(status){
     emailext (
            to: "kumar.vinothvijay@gmail.com",
            subject: "${status} Job Successful '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
            body: """<p>${status}  Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'</p>
                <p>console output at <a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a></p>"""
            )
}

node {

    properties([pipelineTriggers([pollSCM('* * * * *')])])

    try {

        stage('Clone source code') {
            git url: 'https://github.com/sobraljuanpa/ansibleJenkins.git', branch: 'master', credentialsId: 'gitCredentials'
        }

        stage('Check that source is cloned') {
            sh 'ls'
        }

        stage('Execute tests using maven') {
            catchError {
                sh 'cd MavenJunitDemo && mvn clean test'
            }
        }
        
    } catch (e) {

        throw e

    } finally {

        def commitInfo = sh 'git log --format=format:%s -1'
        emailext attachLog: true, body: '', subject: '${CHANGES_SINCE_LAST_BUILD}', to: 'sobraljuanpa@gmail.com'

    }

}
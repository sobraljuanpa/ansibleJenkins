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
            sh 'cd MavenJunitDemo && mvn clean test'
        }

    } catch (e) {

        throw e

    } finally {

        emailext attachLog: true, body: '', subject: 'Commit ${CHANGES_SINCE_LAST_BUILD}', to: 'sobraljuanpa@gmail.com'
        allure([
         includeProperties: false,
         jdk: '',
         properties: [],
         reportBuildPolicy: 'ALWAYS',
         results: [[path: 'MavenJunitDemo/allure-results/']]
         ])
    }

}
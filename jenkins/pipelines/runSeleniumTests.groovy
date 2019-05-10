node {

    properties([pipelineTriggers([pollSCM('* * * * *')])])

    try {

        stage('Clone source code') {
            git url: 'https://github.com/sobraljuanpa/ansibleJenkins.git', branch: 'master', credentialsId: 'gitCredentials'
        }

        stage('Execute tests using maven') {
            sh 'cd MavenJunitDemo && mvn clean test'
        }

    } catch (e) {

        throw e

    } finally {

        allure includeProperties: false, jdk: '', properties: [], reportBuildPolicy: 'ALWAYS', results: [[path: 'MavenJunitDemo/allure-results']]

        emailext attachmentsPattern: '**/allure-report/data/behaviors.json', body: 'Job ${JOB_NAME} build ${BUILD_NUMBER}\n More info at: ${BUILD_URL}', subject: 'Commit ${CHANGES_SINCE_LAST_BUILD}', to: 'juan.sobral@abstracta.com.uy, matias.fornara@abstracta.com.uy'

    }
}
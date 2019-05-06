node {

    properties([pipelineTriggers([pollSCM('* * * * *')])])

    stage('Clone source code') {
        git url: 'https://github.com/sobraljuanpa/ansibleJenkins.git', branch: 'master', credentialsId: 'gitCredentials'
    }

    stage('Check that source is cloned') {
        sh 'ls'
    }

    stage('Execute tests using maven') {
        sh 'mvn test'
    }
}
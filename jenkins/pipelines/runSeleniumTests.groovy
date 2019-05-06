node {

    properties([pipelineTriggers([pollSCM('* * * * *')])])

    stage('Clone source code') {
        git url: 'https://github.com/sobraljuanpa/ansibleJenkins.git', branch: 'master', credentialsId: 'gitCredentials'
    }

    stage('Check that source is cloned') {
        sh 'ls'
    }

    stage('Execute tests using maven') {
        sh 'cd MavenJunitDemo && mvn clean test'//ejecuto las pruebas usando maven
    }
    //mover los archivos al fileserver

    //enviar notificacion por mail
    stage('Send email notification') {
        def commitInfo = sh 'git log --format=format:%s -1'
        emailext attachLog: true, body: '', subject: 'Test results for ${commitInfo}', to: 'matias.fornara@abstracta.com.uy'
    }
}
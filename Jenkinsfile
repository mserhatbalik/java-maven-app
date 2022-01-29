pipeline {
    agent any
    tools {
        maven 'maven-3.8' // Burada Jenkins Global Tool Configuration içerisindeki yarattığın build tool konfigürasyon ismini veriyorsun.
    }
    stages {
        stage("build jar") {
            steps {
                echo 'building the application..'
                sh 'mvn package'
            }
        }
        stage("build image") {
            steps {
                echo 'building the docker image..'
                withCredentials([usernamePassword(credentialsId: 'dockerhub-nana-test-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                    sh 'docker build -t 209.97.182.161:8083/my-latest-app:1.0 .'
                    //sh "echo $PASS | docker login -u $USER --password-stdin 209.97.182.161:8083"
                    sh "docker login -u $USER -p $PASS 209.97.182.161:8083"
                    sh 'docker push 209.97.182.161:8083/my-latest-app:1.0'
                }
            }
        }
        stage("deploy") {
            steps {
                echo 'deploying the application..'
            }
        }
    }   
}

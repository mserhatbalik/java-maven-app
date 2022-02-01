#!/usr/bin/env groovy

@Library('jenkins-shared-library') // Jenkins'in SYSTEM CONF içerisinde belirlediğimiz GLOBAL PIPELINE LIBRARY ismini veriyoruz burada.
def gv

pipeline {
    agent any
    tools {
        maven 'maven-3.8' // Burada Jenkins Global Tool Configuration içerisindeki yarattığın build tool konfigürasyon ismini veriyorsun.
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    buildJar()
                }
            }
        }
        stage("build image") {
            steps {
                    script {
                        buildImage()
                    }
                }
            }
        
        stage("deploy") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }

    }
}

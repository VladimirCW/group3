pipeline {
    agent any

    stages{
        stage('Preparation') {
            steps {
                git 'https://github.com/VladimirCW/group3.git'
            }
        }
        stage('Unit tests') {
            steps{
                bat 'mvn clean -DsuiteXmlFile=unittestng.xml test'
            }
        }
        stage('UI tests') {
            steps{
                bat 'mvn clean -DsuiteXmlFile=testng.xml test'
            }
        }
    }
    post{
        always{
            script {
                allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'allure-results']]
                ])
            }
        }
    }
}
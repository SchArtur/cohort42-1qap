def build_success = true;
currentBuild.displayName = "Build: " + env.TASK + " " + env.BROWSER + " " + env.BRANCH

pipeline {
    agent any

    stages {
        stage('Clean - очищаем рабочую область') {
            steps {
                cleanWs()
            }
        }
        stage('checkout - выкачиваем наш проект') {
            steps {
                git branch: "${env.BRANCH}", url: "https://github.com/SchArtur/cohort42-1qap.git"
            }
        }
        stage('TEST - запуск регрессионных тестов') {
            steps {
                script {
                    try {
                        // Запуск задачи regressionTest
                        sh "gradle regressionTest -Pbrowser=${env.BROWSER}"
                    } catch (e) {
                        build_success = false
                        echo "build failure!"
                    }
                }
            }
        }
    }
}
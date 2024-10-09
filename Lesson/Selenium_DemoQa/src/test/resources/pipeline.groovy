def build_success = true
currentBuild.displayName = "Build: " + env.TAGS + " " + env.REPO_BRANCH

pipeline {
    agent any //тут указывается агент для запуска кода. any - любой

    stages {
        stage('Clean - очищаем рабочую область'){
            steps {
                cleanWs()
            }
        }

        stage('checkout - выкачиваем наш проект') {
            steps {
                git branch: "${env.REPO_BRANCH}", url: 'https://github.com/SchArtur/cohort42-1qap.git'
            }
        }

        stage('TEST - запуск тестов') {
            steps {
                script {
                    try {
                        sh "mvn -pl ${env.MODULE} test -DincludeTags=${env.TAGS}"
                    } catch (e) {
                        build_success = false
                        echo "build failure!"
                    }
                }
            }
        }
    }
}

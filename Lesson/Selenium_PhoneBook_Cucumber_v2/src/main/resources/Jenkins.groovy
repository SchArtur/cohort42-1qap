//def build_success = true
//
//currentBuild.dispayName = "Build: " + env.TAGS + " " + env.BROWSER + " " + env.BRANCH
//pipeline {
//    // agent any - тут указывается агент для запуска кода. any - любой
//    agent {label 'mac'}
//
//    stages {
//        stage('Clean - очищаем рабочую область'){
//            steps {
//                cleanWs()
//            }
//        }
//
//        stage('checkout - выкачиваем наш проект') {
//            steps {
//                git branch "${env.BRANCH}", url "https://github.com/SchArtur/cohort42-1qap.git"
//            }
//        }
//
//        stage('TEST - запуск тестов') {
//            steps {
//               script {
//                   try {
//                       sh "gradle Lesson:Selenium_PhoneBook_v1:test -Ptags=${env.TAGS} -Pbrowser=${env.BROWSER}"
////                       cmd "gradle Lesson:Selenium_PhoneBook_v1:test -Ptags=${env.TAGS} -Pbrowser=${env.BROWSER}" - для windows
//                   } catch (e) {
//                       build_success =false
//                       echo "build failure!"
//                   }
//               }
//            }
//        }
//    }
//}

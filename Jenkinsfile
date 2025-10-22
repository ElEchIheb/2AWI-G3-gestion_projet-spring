pipeline {
    agent any

    tools {
        maven 'maven3'
        jdk 'jdk17'
    }

    stages {
        stage('Checkout') {
            steps {
                echo '📥 Clonage du dépôt GitHub...'
                git branch: 'AhmedBENYOUNES-AWI2-G3', url: 'https://github.com/ElEchIheb/2AWI-G3-gestion_projet-spring.git'
            }
        }

        stage('Build') {
            steps {
                echo '⚙️ Compilation du projet Spring Boot...'
                bat 'mvnw.cmd clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                echo '🧪 Exécution des tests unitaires...'
                bat 'mvnw.cmd test'
            }
        }

        stage('Archive') {
            steps {
                echo '📦 Archivage du JAR généré...'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('Deploy') {
            steps {
                echo '🚀 Déploiement local du JAR...'
                bat 'start /B java -jar target\\*.jar'
            }
        }
    }

    post {
        success {
            echo '✅ Build réussi !'
        }
        failure {
            echo '❌ Échec du build.'
        }
    }
}

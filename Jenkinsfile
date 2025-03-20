pipeline {
    agent any
    tools {
        maven 'Maven'
    }
     environment {
            // Define Docker Hub credentials ID
            DOCKERHUB_CREDENTIALS_ID = 'Docker_Hub'
            // Define Docker Hub repository name
            DOCKERHUB_REPO = 'ash4docdesk/shoppingcartapp'
            // Define Docker image tag
            DOCKER_IMAGE_TAG = 'latest_v3'
        }
    stages {
        stage('Checkout') {
            steps{
                git branch: 'main', url: 'https://github.com/zisudes/ShoppingCart.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }


         stage('Build Docker Image') {
            steps {
                // Build Docker image
                script {
                    docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                }
            }
        }
        stage('Push Docker Image to Docker Hub') {
            steps {
                // Push Docker image to Docker Hub
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS_ID) {
                        docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                    }
                }
            }
        }
    }
}
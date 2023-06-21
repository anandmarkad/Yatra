pipeline {

    options {
        buildDiscarder(logRotator(numToKeepStr: '5',
         artifactNumToKeepStr: '5'))
    }

    agent {label 'Jenkins_S'}
    tools {
        maven 'maven_3.8.8'
    }

    stages {
        stage('Code Compilation') {
            steps {
                echo 'code compilation is starting'
                sh 'mvn clean compile'
				echo 'code compilation is completed'
            }
        }
        stage('Code Test') {
            steps {
                echo 'code Testing is starting'
                sh 'mvn clean test'
				echo 'code Test is completed'
            }
        }

        stage('Code Package') {
            steps {
                echo 'code packing is starting'
                sh 'mvn clean package'
				echo 'code packing is completed'
            }
        }
                    stage('Building & Tag Docker Image') {
                            steps {
                                echo 'Starting Building Docker Image'
                                sh 'docker build -t anandmarkad4/yatra:latest .'
                                sh 'docker build -t yatra:latest .'
                                echo 'Completed  Building Docker Image'
                            }
                    }
                stage('Docker Image Scanning') {
                            steps {
                                echo 'Docker Image Scanning Started'
                                sh 'java --version'
                                echo 'Docker Image Scanning Started'
                            }
                }
                 stage(' Docker push to Docker Hub') {
                           steps {
                              script {
                                 withCredentials([string(credentialsId: 'dockerhubCred', variable: 'dockerhubCred')])
                                 {
                                 sh 'docker login docker.io -u anandmarkad4 -p ${dockerhubCred}'
                                 echo "Push Docker Image to DockerHub : In Progress"
                                 sh 'docker push anandmarkad4/yatra:latest'
                                 echo "Push Docker Image to DockerHub : In Progress"
                                 sh 'whoami'
                                 }
                              }
                           }
                 }

                stage(' Docker Image Push to Amazon ECR') {
                           steps {
                              script {
                                 withDockerRegistry([credentialsId:'ecr:us-east-1:ecr-credentials', url:"https://a7j4w5s4.dkr.ecr.us-east-1.amazonaws.com"])
                                 {
                                 echo "List the docker images present in local"
                                 sh 'docker images'
                                 echo "Tagging the Docker Image: In Progress"
                                 sh 'docker tag yatra:latest public.ecr.aws/a7j4w5s4/yatra:latest'
                                 echo "Tagging the Docker Image: Completed"
                                 echo "Push Docker Image to ECR : In Progress"
                                 sh 'docker push public.ecr.aws/a7j4w5s4/yatra:latest'
                                 echo "Push Docker Image to ECR : Completed"
                                 }
                              }
                           }
                }
    }
}
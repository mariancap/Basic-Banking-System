def remote=[:]
remote.name = 'ec2-user'
remote.host = '54.227.169.121'
remote.allowAnyHosts = true

pipeline {
    agent any
    environment{
        PI_CREDS=credentials('ec2-user')
        DOCKER_CREDS = credentials('mariancap')
    }
    tools {
        maven "Maven"
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/mariancap/Basic-Banking-System.git'
            }
        }
        stage('Execute Maven') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Clean Docker Environment') {
            steps {
                script {
                    remote.user = env.PI_CREDS_USR
                    remote.password = env.PI_CREDS_PSW
                }
                sshCommand(remote: remote, command: "sudo docker container prune -f")
                sshCommand(remote: remote, command: "sudo docker image prune -f")
                sshCommand(remote: remote, command: "sudo docker system prune -f")
            }
        }
        stage('Copy artifact file') {
            steps {
                script {
                    remote.user = env.PI_CREDS_USR
                    remote.password = env.PI_CREDS_PSW
                }
                sshCommand(remote: remote, command: "sudo chmod o+w /opt/")
                sshPut remote: remote, from: '/var/lib/jenkins/workspace/app-deploy-docker/target/BankingSystem-1.0-SNAPSHOT.war', into: '/opt/'
            }
        }
        stage('Docker Build and Tag') {
            steps {
                script {
                    remote.user = env.PI_CREDS_USR
                    remote.password = env.PI_CREDS_PSW
                }
                sshCommand(remote: remote, command: "cd /opt")
                sshCommand(remote: remote, command: "sudo docker build -t banking-sys:latest /opt/")
                sshCommand(remote: remote, command: "sudo docker tag banking-sys mariancap/banking-sys:latest")
            }
        }
        stage('Publish image to Docker Hub') {
            steps {
                script {
                    remote.user = env.PI_CREDS_USR
                    remote.password = env.PI_CREDS_PSW
                }
                // Folosim credentalele Docker Hub
                withCredentials([usernamePassword(credentialsId: 'mariancap', usernameVariable: 'DOCKERHUB_USER', passwordVariable: 'DOCKERHUB_PASS')]) {
                    sshCommand(remote: remote, command: "sudo docker login -u $DOCKERHUB_USER -p $DOCKERHUB_PASS")
                    sshCommand(remote: remote, command: "sudo docker push mariancap/banking-sys:latest")
                }
            }
        }
        stage('Run Tomcat Container') {
            steps {
                script {
                    remote.user = env.PI_CREDS_USR
                    remote.password = env.PI_CREDS_PSW
                }
                // Stop and remove any existing container with the same name
                sshCommand(remote: remote, command: "if [ \$(sudo docker ps -aq -f name=marian-container) ]; then sudo docker stop marian-container; sudo docker rm marian-container; fi")
                // Run the new container
                sshCommand(remote: remote, command: "sudo docker run -d --name marian-container -p 8081:8080 mariancap/banking-sys:latest")
            }
        }
    }
    post {
        always {
            sleep 5
        }
    }
}

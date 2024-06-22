pipeline {
    agent any
    environment {
        imageName = "staleks/template-goose"
        dockerFileLocation = "./app"
        latestTag = "latest"
        releaseCandidateTag = "RC"
    }

    stages {
        stage('Prepare') {
            steps {
                checkout(scm: scm, poll: true, changelog: true)
                sh './gradlew clean --stacktrace'
            }
        }
        stage('Compile') {
            steps {
                sh './gradlew classes testClasses --stacktrace'
                warnings(consoleParsers: [[parserName: 'Java Compiler (javac)']], usePreviousBuildAsReference: true)
            }
        }
    }
}
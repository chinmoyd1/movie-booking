node{
    tools {
        maven 'apache-maven-3.0.1' 
    }
    stage('SCM Checkout'){
        git 'https://github.com/chinmoyd1/movie-booking'
    }
    stage('build-discovery-service'){
      dir("${env.WORKSPACE}/dicovery-service"){
          sh "pwd"
          sh "mvn --version"
          echo 'Building..'
          sh "mvn clean install"
      }    
    }
}

node {
    stage('SCM Checkout'){
        git 'https://github.com/chinmoyd1/movie-booking'
    }
    stage('build-discovery-service'){
      dir("${env.WORKSPACE}/dicovery-service"){
          sh "pwd"
          sh 'mvn clean install'
      }    
    }
    stage('build-turbine-service'){
      dir("${env.WORKSPACE}/turbine-service"){
          sh "pwd"
          sh 'mvn clean install'
      }    
    }
    stage('build-turbine-service'){
      dir("${env.WORKSPACE}/authenticate-service"){
          sh "pwd"
          sh 'mvn clean install'
      }    
    }
}

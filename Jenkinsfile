node {
    stage('SCM Checkout'){
        git 'https://github.com/chinmoyd1/movie-booking'
    }
    stage('build-discovery-service'){
      dir("${env.WORKSPACE}/dicovery-service"){
          sh 'pwd'
          sh 'mvn --version'
          echo 'Building..'
          sh 'mvn clean install'
      }    
    }
}

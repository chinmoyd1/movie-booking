node{
  stage('SCM Checkout'){
      git 'https://github.com/chinmoyd1/movie-booking'
  }
  stage('build-discovery-service'){
    sh 'cd discovery-service'
    sh 'mvn clean install'
  }
   stage('build-turbine-service'){
    sh 'cd turbine-service'
    sh 'mvn clean install'
  }
}

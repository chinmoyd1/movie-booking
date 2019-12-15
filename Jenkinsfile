node {
    stage('SCM Checkout'){
        git 'https://github.com/chinmoyd1/movie-booking'
    }
    stage('build-authenticate-service'){
      dir("${env.WORKSPACE}/authenticate-service"){
          sh "pwd"
          sh 'mvn clean install -Dmaven.test.skip=true'
      }    
    }
}

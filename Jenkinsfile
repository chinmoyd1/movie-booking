node {
    stage('SCM Checkout'){
        git 'https://github.com/chinmoyd1/movie-booking'
    }
    stage('build-discovery-service'){
      dir("${env.WORKSPACE}/dicovery-service"){
          sh "pwd"
          sh 'mvn clean install -Dmaven.test.skip=true'
      }    
    }
    stage('build-turbine-service'){
      dir("${env.WORKSPACE}/turbine-service"){
          sh "pwd"
          sh 'mvn clean install -Dmaven.test.skip=true'
      }    
    }
    stage('build-authenticate-service'){
      dir("${env.WORKSPACE}/authenticate-service"){
          sh "pwd"
          sh 'mvn clean install -Dmaven.test.skip=true'
      }    
    }
    stage('build-booking-service'){
        dir("${env.WORKSPACE}/booking-service"){
          sh "pwd"
          sh 'mvn clean install -Dmaven.test.skip=true'
      }    
    }
    stage('build-notfiacation-service')
      dir("${env.WORKSPACE}/notfiacation-service"){
          sh "pwd"
          sh 'mvn clean install -Dmaven.test.skip=true'
      }    
    }
    stage('build-theatre-service'){
        dir("${env.WORKSPACE}/theatre-service"){
          sh "pwd"
          sh 'mvn clean install -Dmaven.test.skip=true'
      }    
    }
}

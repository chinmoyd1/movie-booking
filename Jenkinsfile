node {
    stage('SCM Checkout'){
        git 'https://github.com/chinmoyd1/movie-booking'
    }
    stage('build-discovery-service'){
      dir("${env.WORKSPACE}/dicovery-service"){
          sh "pwd"
          sh 'mvn clean install -Dmaven.test.skip=true'
	  sh 'docker build -t rick1113/dicovery-service .'
 	  sh "docker login -u rick1113 -p 12Pass12"
	  sh 'docker push rick1113/dicovery-service'
      }    
    }
    stage('build-turbine-service'){
      dir("${env.WORKSPACE}/turbine-service"){
          sh "pwd"
          sh 'mvn clean install -Dmaven.test.skip=true'
	  sh 'docker build -t rick1113/turbine-service .'
 	  sh "docker login -u rick1113 -p 12Pass12"
	  sh 'docker push rick1113/turbine-service'
      }    
    }
    stage('build-authenticate-service'){
      dir("${env.WORKSPACE}/authenticate-service"){
          sh "pwd"
          sh 'mvn clean install -Dmaven.test.skip=true'
	  sh 'docker build -t rick1113/authenticate-service .'
 	  sh "docker login -u rick1113 -p 12Pass12"
	  sh 'docker push rick1113/authenticate-service'
      }    
    }
    stage('build-booking-service'){
       dir("${env.WORKSPACE}/booking-service"){
          sh "pwd"
          sh 'mvn clean install -Dmaven.test.skip=true'
	  sh 'docker build -t rick1113/booking-service .'
 	  sh "docker login -u rick1113 -p 12Pass12"
	  sh 'docker push rick1113/booking-service'
	       
      }    
    }
    stage('build-notification-service'){
      dir("${env.WORKSPACE}/notification-service"){
          sh "pwd"
          sh 'mvn clean install -Dmaven.test.skip=true'
	  sh 'docker build -t rick1113/notification-service .'
 	  sh "docker login -u rick1113 -p 12Pass12"
	  sh 'docker push rick1113/notification-service'
      }    
    }
    stage('build-theatre-service'){
       dir("${env.WORKSPACE}/theatre-service"){
          sh "pwd"
          sh 'mvn clean install -Dmaven.test.skip=true'
	  sh 'docker build -t rick1113/theatre-service .'
 	  sh "docker login -u rick1113 -p 12Pass12"
	  sh 'docker push rick1113/theatre-service'
      }    
    }
}

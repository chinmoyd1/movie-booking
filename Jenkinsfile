node {
    stage('SCM Checkout'){
        git 'https://github.com/chinmoyd1/movie-booking'
    }
    stage('build-discovery-service'){
      def mvnHome =  tool name: 'maven-3', type: 'maven'
      def mvnCMD = "${mvnHome}/bin/mvn"
      dir("${env.WORKSPACE}/dicovery-service"){
          sh "pwd"
          sh "${mvnCMD} --version"
          echo 'Building..'
          sh "${mvnCMD} clean install -s ../mvn-settings.xml"
      }    
    }
}

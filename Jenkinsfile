
    pipeline {
        agent any
           timeout(5,'MINUTES') {
   // steps to execute
        }
            stages {

                   stage('Stage clone the repository') {
                       timeout(5,'MINUTES') {
   // steps to execute
}
                    steps {
                             git 'https://github.com/shubham823/play.git'
                        }
                }
                stage('Stage playbook') {
                    steps{
         
         ansiblePlaybook credentialsId: '74ee0ed5-fa02-49f7-9580-1c92420ab346', installation: 'ansible', inventory: 'hosts', playbook: 'installTomcat.yml'
     }
                }

            }
        }
    

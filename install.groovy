pipelineJob('job-name') {
    parameters {
        stringParam('target_host', '192.168.29.200', 'ip off target_host')
    }
  definition {
    cps {
      script('''
        pipeline {
            agent any
                stages {
                     
                       stage('Stage clone the repository') {
                        steps {
                                 git 'https://github.com/shubham823/play.git'
                            }
                    }
                    stage('Stage playbook') {
                        steps{
             script {
                 withCredentials([sshUserPrivateKey(credentialsId: '74ee0ed5-fa02-49f7-9580-1c92420ab346', keyFileVariable: 'keyfile')]) {
                    ansiblePlaybook(
                        installation: 'ansible',
                        playbook: 'installTomcat.yml',
                        inventory: 'hosts',
                        colorized: true,
                         extraVars: [
                             target_host: "${params.target_host}"
                             ]
                        ) 
                 }
             }
    //         ansiblePlaybook credentialsId: '74ee0ed5-fa02-49f7-9580-1c92420ab346', installation: 'ansible', inventory: 'hosts', playbook: 'installTomcat.yml'
         }
                    }
                
                }
            }
        }
      '''.stripIndent())
      sandbox()     
    }
  }
  }


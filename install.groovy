pipelineJob('check pipeline DSL') {
  definition {
    cps {
      script('''
        pipeline {
            agent any
                stages {
                    stage('Setup parameters') {
                    steps {
                        script { 
                             properties([
                                parameters([
                                  string(
                                defaultValue: '192.168.29.200', 
                                name: 'target-host', 
                                trim: true
                            )
                        ])
                    ])  
                       }
                       }
                       }  
                       stage('Stage clone the repository') {
                        steps {
                                 git 'https://github.com/shubham823/play.git'
                            }
                    }
                    stage('Stage playbook') {
                        steps {
                            ansiblePlaybook credentialsId: '74ee0ed5-fa02-49f7-9580-1c92420ab346', installation: 'ansible', inventory: 'hosts', playbook: 'installTomcat.yml'
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

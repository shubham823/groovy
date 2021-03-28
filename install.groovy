pipelineJob('seeded') {
   
   parameters {
        stringParam('target_host', '192.168.29.200', 'ip off target_host')
    }
  
  definition {
    cps {
       options { buildDiscarder(logRotator(numToKeepStr: '1')) }
      script(readFileFromWorkspace('Jenkinsfile'))
      sandbox()     
    }
  }
}

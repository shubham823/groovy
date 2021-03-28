pipelineJob('seeded') {
   
   parameters {
        stringParam('target_host', '192.168.29.200', 'ip off target_host')
    }
  
  definition {
    cps {
       
      script(readFileFromWorkspace('Jenkinsfile'))
      sandbox()     
    }
  }
}

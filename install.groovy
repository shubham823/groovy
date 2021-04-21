pipelineJob('seeded') {
   
  definition {
   logRotator {
        numToKeep(30)
       
    }
    
     concurrentBuild(false)
   parameters {
        stringParam('target_host', '192.168.29.200', 'ip off target_host')
         stringParam('branch', null, 'feature branch')
      stringParam('brancjh')
    }
  
    cpsScm {
       scm{
          git{
             branch("*/master")
             remote{
                url('https://github.com/shubham823/groovy.git')
                   
                
                
             }
             
          }
          
       }
       scriptPath('Jenkinsfile')     
    }
  }
}

pipelineJob('seeded') {
  definition {
  properties([buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '30')), [$class: 'ScannerJobProperty', doNotScan: false]])
   parameters {
        stringParam('target_host', '192.168.29.200', 'ip off target_host')
    }
  
  
    cps {
      script(readFileFromWorkspace('Jenkinsfile'))
      sandbox()     
    }
  }
}
